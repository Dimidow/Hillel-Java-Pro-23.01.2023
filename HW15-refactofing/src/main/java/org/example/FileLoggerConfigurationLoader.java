package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileLoggerConfigurationLoader {

    private final Pattern pattern = Pattern.compile("\\[(.*?)\\]\\[(.*?)\\] (.*)");

    public FileLoggerConfiguration load(String filePath, long maxSize, String format) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        LoggingLevel level = null;
        String message = null;
        Matcher matcher;

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            matcher = pattern.matcher(line);
            if (matcher.find()) {
                String date = matcher.group(1);
                level = LoggingLevel.valueOf(matcher.group(2));
                message = matcher.group(3);

                System.out.println("Дата: " + date);
                System.out.println("Уровень логирования: " + level);
                System.out.println("Сообщение: " + message);
            }
        }


        bufferedReader.close();

        return new FileLoggerConfiguration(filePath, level, maxSize, format);
    }
}