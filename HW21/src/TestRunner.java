import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import annotations.AfterSuite;
import annotations.BeforeSuite;
import annotations.Test;

public class TestRunner {

    public static void start(Class<?> testClass) throws Exception {
        Map<String, Method> annotatedMethods = findBeforeAfterMethods(testClass);
        Map<Integer, List<Method>> testMethods = findTestMethods(testClass);
        invokeAnnotatedMethods(annotatedMethods, testMethods);
    }

    private static void invokeAnnotatedMethods(Map<String, Method> annotatedMethods, Map<Integer, List<Method>> testMethods) throws Exception {
        if (annotatedMethods.containsKey("BeforeSuite")) {
            annotatedMethods.get("BeforeSuite").invoke(null);
        }
        for (int testPriority : testMethods.keySet()) {
            List<Method> list = testMethods.get(testPriority);
            for (Method method : list) {
                method.invoke(null);
            }
        }
        if (annotatedMethods.containsKey("AfterSuite")) {
            annotatedMethods.get("AfterSuite").invoke(null);
        }
    }

    private static Map<Integer, List<Method>> findTestMethods(Class<?> testClass) {
        Map<Integer, List<Method>> testMethods = new TreeMap<>();

        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                Test test = method.getAnnotation(Test.class);
                int priority = test.testPriority();
                List<Method> list = testMethods.getOrDefault(priority, new ArrayList<>());
                list.add(method);
                testMethods.put(priority, list);
            }
        }
        return testMethods;
    }

    private static Map<String, Method> findBeforeAfterMethods(Class<?> testClass) {
        Map<String, Method> beforeAfterMethods = new HashMap<>();

        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (beforeAfterMethods.containsKey("BeforeSuite")) {
                    throw new RuntimeException("There can only be one @BeforeSuite annotation");
                }
                beforeAfterMethods.put("BeforeSuite", method);
            } else if (method.isAnnotationPresent(AfterSuite.class)) {
                if (beforeAfterMethods.containsKey("AfterSuite")) {
                    throw new RuntimeException("There can only be one @AfterSuite annotation");
                }
                beforeAfterMethods.put("AfterSuite", method);
            }
        }
        return beforeAfterMethods;
    }
}