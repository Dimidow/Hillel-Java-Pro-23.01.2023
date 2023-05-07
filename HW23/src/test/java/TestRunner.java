import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.my.homeworks.ProjectTestRunner;
import org.my.homeworks.TestResult;
import org.my.homeworks.TestResultParser;
import org.junit.runner.Result;


public class TestRunner {

    public static final String PATH_TO_TEST_CLASSES = "src/test/java/";

    public static void main(String[] args) {

        ProjectTestRunner testRunner = new ProjectTestRunner();
        List<String> testClassNamesList = new ArrayList<>();
        testClassNamesList.add("SimpleMathLibraryTest");
        testClassNamesList.add("SimpleMathLibraryTest");

        System.out.println("\nrun tests by package:");
        testRunner.runTestsByPackage(PATH_TO_TEST_CLASSES);
        System.out.println("\nrun tests by class:");
        testRunner.runTestByClass(SimpleMathLibraryTest.class);
        System.out.println("\nrun tests by class name:");
        testRunner.runTestByClassName("SimpleMathLibraryTest", PATH_TO_TEST_CLASSES);
        System.out.println("\nrun tests by class names:");
        testRunner.runTestsByClassNames(testClassNamesList, PATH_TO_TEST_CLASSES);
        System.out.println("\nrun tests by classes:");
        Result result = testRunner.runTestsByClasses(SimpleMathLibraryTest.class, SimpleMathLibraryTest.class);
        //print to console test results
        System.out.println("Test run finished after " + result.getRunTime() + " ms");
        System.out.println("[ " + result.getRunCount() + " containers found ]");
        System.out.println("[ " + result.getIgnoreCount() + " containers skipped ]");
        System.out.println("[ " + (result.getRunCount() - result.getIgnoreCount()) + " containers started ]");
        System.out.println("[ " + result.getAssumptionFailureCount() + " containers aborted ]");
        System.out.println("[ " + (result.getRunCount() - result.getIgnoreCount() - result.getAssumptionFailureCount()) + " containers successful ]");
        System.out.println("[ " + result.getFailureCount() + " containers failed ]");
        System.out.println("[ " + result.getFailureCount() + " tests found ]");
        System.out.println("[ " + result.getIgnoreCount() + " tests skipped ]");

        //load from file
        TestResultParser parser = new TestResultParser();
        File file = new File("src/main/resources/TestResultsFileForUpload.txt");
        Path path = Paths.get(file.getPath());
        try {
            //TestResult testLoadingFromFile = parser.parse("src/main/resources/TestResultsFileForUpload.txt");
            //TestResult testLoadingFromFile = parser.parse(file);
            TestResult testLoadingFromFile = parser.parse(path);
            System.out.println("Total tests: " + testLoadingFromFile.getTotalTests());
            System.out.println("Successful tests: " + testLoadingFromFile.getSuccessfulTests());
            System.out.println("Failed tests: " + testLoadingFromFile.getFailedTests());
            System.out.println("Test run time: " + testLoadingFromFile.getTestRunTime() + " ms");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}