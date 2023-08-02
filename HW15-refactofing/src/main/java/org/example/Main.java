package org.example;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String filePath = "src/main/resources/";
        String format = "[TIME][LEVEL] Message: [MESSAGE]";
        long maxSize = 1024 * 1024 * 1024;
        FileLoggerConfiguration config = new FileLoggerConfiguration(
            filePath,
            LoggingLevel.DEBUG,
            maxSize,
            format
        );
        FileLogger logger = new FileLogger(config);
        logger.info("Starting application...");
        logger.debug("Debugging information...");
        logger.info("Application started successfully.");
        logger.close();

        File folder = new File(filePath);
        File[] listOfFiles = folder.listFiles();
        FileLoggerConfigurationLoader fileLoggerConfigurationLoader = new FileLoggerConfigurationLoader();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                fileLoggerConfigurationLoader.load(filePath + file.getName(), maxSize, format);
            }
        }
        double result = BasicMathLibrary.add(2, 3);
        System.out.println("\nresult of adding by Simple Math operations\n" + result);
    }
}