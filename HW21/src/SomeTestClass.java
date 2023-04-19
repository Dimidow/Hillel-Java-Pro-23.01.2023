import annotations.AfterSuite;
import annotations.BeforeSuite;
import annotations.Test;

public class SomeTestClass {

    @BeforeSuite
    public static void before() {
        System.out.println("BeforeSuite method called");
    }

    @Test(testPriority = 3)
    public static void testMethod1() {
        System.out.println("TestMethod1 with testPriority 3 called");
    }

    @Test(testPriority = 1)
    public static void testMethod2() {
        System.out.println("TestMethod2 with testPriority 1 called");
    }

    @Test(testPriority = 4)
    public static void testMethod3() {
        System.out.println("TestMethod3 with testPriority 5 called");
    }

    @AfterSuite
    public static void after() {
        System.out.println("AfterSuite method called");
    }
}
