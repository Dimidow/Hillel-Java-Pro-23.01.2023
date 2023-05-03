package org.example;

public class TestResult {

    private final int totalTests;
    private final int successfulTests;
    private final int failedTests;
    private final String testRunTime;

    public TestResult(int totalTests, int successfulTests, int failedTests, String testRunTime) {
        this.totalTests = totalTests;
        this.successfulTests = successfulTests;
        this.failedTests = failedTests;
        this.testRunTime = testRunTime;
    }

    public int getTotalTests() {
        return totalTests;
    }

    public int getSuccessfulTests() {
        return successfulTests;
    }

    public int getFailedTests() {
        return failedTests;
    }

    public String getTestRunTime() {
        return testRunTime;
    }
}
