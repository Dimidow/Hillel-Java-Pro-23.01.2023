package org.my.homeworks;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestResultParser {


    public TestResult parse(String filePath) throws IOException {
        return parseFile(new File(filePath));
    }

    public TestResult parse(File file) throws IOException {
        return parseFile(file);
    }

    public TestResult parse(Path path) throws IOException {
        return parseFile(path.toFile());
    }

    private TestResult parseFile(File file) {
        int totalTests = 0;
        int successfulTests = 0;
        int failedTests = 0;
        String testRunTime = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("[") && line.contains("]")) {
                    String[] parts = line.split(" ");
                    int value = Integer.parseInt(parts[1]);
                    if (line.contains("containers found")) {
                        totalTests = value;
                    } else if (line.contains("containers successful")) {
                        successfulTests = value;
                    } else if (line.contains("containers failed")) {
                        failedTests = value;
                    } else if (line.contains("tests found")) {
                        totalTests = value;
                    } else if (line.contains("tests successful")) {
                        successfulTests = value;
                    } else if (line.contains("tests failed")) {
                        failedTests = value;
                    }
                }
                if (line.contains("Test run finished")) {
                    Pattern pattern = Pattern.compile("\\d+");
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        testRunTime = matcher.group(0);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new TestResult(totalTests, successfulTests, failedTests, testRunTime);
    }
}