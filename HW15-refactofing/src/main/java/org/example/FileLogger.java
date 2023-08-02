package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {

    private final FileLoggerConfiguration configuration;
    private File currentFile;
    private FileWriter writer;
    private long currentSize;

    public FileLogger(FileLoggerConfiguration configuration) throws IOException {
        this.configuration = configuration;
        this.currentSize = 0;
        rotateFile();
    }

    public void info(String message) throws IOException {
        log(LoggingLevel.INFO, message);
    }

    public void debug(String message) throws IOException {
        log(LoggingLevel.DEBUG, message);
    }

    public void close() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            System.err.println("Error closing file writer: " + e.getMessage());
        }
    }

    private void log(LoggingLevel level, String message) throws IOException {
        if (level.ordinal() > configuration.getLevel().ordinal()) {
            return;
        }

        String log = String.format("[%s][%s] %s\n", getCurrentTime(), level.name(), message);

        synchronized (this) {
            if (currentSize + log.getBytes().length > configuration.getMaxSize()) {
                rotateFile();
            }
            writer.write(log);
            writer.flush();
            currentSize += log.getBytes().length;
        }
    }

    private String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }

    private void rotateFile() throws IOException {
        if (writer != null) {
            writer.close();
        }

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy-HH.mm");
        String fileName = "Log_" + now.format(formatter) + ".txt";


        currentFile = new File(configuration.getFile(), fileName);
        writer = new FileWriter(currentFile, true);
        currentSize = currentFile.length();
    }
}