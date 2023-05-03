package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class MyTestWatcher extends TestWatcher {

    public final String PATH_TO_TEST_REPORT = "src/main/resources/";
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy-HH.mm.SSS");
    private File testReportFile;

    private int testCount = 0;
    private int skippedCount = 0;
    private int failureCount = 0;
    private long startTime;
    private long duration;
    public MyTestWatcher() {
        createFile();
    }

    @Override
    protected void succeeded(Description description) {
        testCount++;
    }

    @Override
    protected void failed(Throwable e, Description description) {
        failureCount++;
    }

    @Override
    protected void skipped(org.junit.AssumptionViolatedException e, Description description) {
        skippedCount++;
    }

    @Override
    protected void starting(Description description) {
        startTime = System.currentTimeMillis();
        writeLineToFile(String.format("[ %d containers found ]", description.testCount()));
        writeLineToFile(String.format("[ %d containers skipped ]", description.getChildren().size()));
        writeLineToFile(String.format("[ %d containers started ]", description.testCount()));
        writeLineToFile("[ 0 containers aborted ]");
    }

    @Override
    protected void finished(Description description) {
        long duration = System.currentTimeMillis() - startTime;
        writeLineToFile(String.format("[ %d containers successful ]", testCount - skippedCount - failureCount));
        writeLineToFile(String.format("[ %d containers failed ]", failureCount));
        writeLineToFile(String.format("[ %d tests found ]", testCount));
        writeLineToFile(String.format("[ %d tests skip ]", skippedCount));
        writeLineToFile("Test run finished after " + duration + " ms");
    }

    private void createFile() {
        if (testReportFile == null) {
            String testReportName = "Test Report from_" + LocalDateTime.now().format(formatter) + ".txt";
            testReportFile = new File(PATH_TO_TEST_REPORT, testReportName);
            try {
                testReportFile.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void writeLineToFile(String line) {
        try (FileWriter writer = new FileWriter(testReportFile, true)) {
            writer.write(line + "\n");
        } catch (IOException e) {
            System.err.println("Error writing to test report file: " + e.getMessage());
        }
    }
}
