import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

import exceptions.IncorrectFileNameException;
import exceptions.IncorrectFilePathException;
import exceptions.IncorrectFileSizeException;

public class FileNavigator {

    private final TreeMap<String, List<FileData>> fileNavigatorTm = new TreeMap<>();
    private final String filesPath;

    public FileNavigator(String filesPath) throws IOException {
        this.filesPath = filesPath;
        File folder = new File(filesPath);
        List<FileData> fileDataList = new LinkedList<>();
        for (final File file : folder.listFiles()) {
            fileDataList.add(new FileData(file.getName(), Files.size(Paths.get(filesPath + file.getName())), filesPath));
        }
        fileNavigatorTm.put(filesPath, fileDataList);
    }

    public void add(FileData fileData){

        try {
            List<FileData> dataList = fileNavigatorTm.get(filesPath);

            if (!fileData.getPath().equals(dataList.get(0).getPath())) {
                throw new IncorrectFilePathException("Inconsistent path and key for file " + fileData.getPath() + " in " + fileData);
            }

            if (fileData.getSize() == 0) {
                throw new IncorrectFileSizeException("Incorrect size: " + fileData.getSize() + " in " + fileData);
            }

            if (!fileData.getName().matches("^[a-zA-Z0-9._ -]+\\.(java|doc|pdf|csv|xls)$")) {
                throw new IncorrectFileNameException("Incorrect name: " + fileData.getName() + " in " + fileData);
            }

            dataList.add(fileData);
            fileNavigatorTm.put(fileData.getPath(), dataList);
        } catch (IncorrectFilePathException | IncorrectFileSizeException | IncorrectFileNameException e) {
            System.err.println("Error adding file: " + e.getMessage());
        }
    }

    public List<FileData> find(String path){
        return fileNavigatorTm.get(path);
    }

    public List<FileData> filterBySize(long maxFileSizeBytes) {
        return fileNavigatorTm.get(filesPath).stream()
                              .filter(fileData -> fileData.getSize() >= maxFileSizeBytes)
                              .collect(Collectors.toList());
    }

    public void remove(String path) {
        try {
            if (fileNavigatorTm.get(path) == null) {
                throw new FileNotFoundException("File path not found: " + path);
            } else {
                fileNavigatorTm.remove(path);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }

    public List<FileData> sortBySize() {
        return fileNavigatorTm.get(filesPath).stream()
                              .sorted(Comparator.comparingLong(FileData::getSize))
                              .collect(Collectors.toList());
    }
}
