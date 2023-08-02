import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FileLoggerConfigurationLoader {

    private final String filePath = FileLoggerConfiguration.getFilePath();
    private final double maxFileSize = FileLoggerConfiguration.getMaxFileSize();
    private final Scanner logsFileScanner;
    private final LogStructure logStructure;

    public FileLoggerConfigurationLoader() throws FileNotFoundException {
        logsFileScanner = new Scanner(FileLoggerConfiguration.getFile());
        logStructure = new LogStructure();
    }

    public List<FileLoggerConfiguration> load() throws ParseException, FileMaxSizeReachedException {
        List<FileLoggerConfiguration> loadedFileLoggerConfigurations = new LinkedList<>();

        while (logsFileScanner.hasNext()) {
            String logItem = logsFileScanner.next();
            Date date = logStructure.getSimpleDateFormat().parse(logItem);
            String loggingLevel = logsFileScanner.next();
            String message = logsFileScanner.nextLine();
            LogStructure logFormat = new LogStructure(date, loggingLevel, message);
            FileLoggerConfiguration fileLoggerConfiguration = new FileLoggerConfiguration(filePath, loggingLevel, maxFileSize, logFormat);
            loadedFileLoggerConfigurations.add(fileLoggerConfiguration);
        }

        return loadedFileLoggerConfigurations;
    }
}
