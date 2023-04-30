package org.example;

public class FileLoggerConfiguration {

    private final String file;
    private final LoggingLevel level;
    private final long maxSize;
    private final String format;

    public FileLoggerConfiguration(String file, LoggingLevel level, long maxSize, String format) {
        this.file = file;
        this.level = level;
        this.maxSize = maxSize;
        this.format = format;
    }

    public String getFile() {
        return file;
    }
    public LoggingLevel getLevel() {
        return level;
    }
    public long getMaxSize() {
        return maxSize;
    }
}