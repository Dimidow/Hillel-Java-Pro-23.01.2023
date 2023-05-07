package org.my.homeworks;


import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;


public class ProjectTestRunner {

    private final JUnitCore runner;

    public ProjectTestRunner() {
        runner = new JUnitCore();
    }

    public Result runTestByClassName(String className, String pathToClass) {
        Result result = null;
        try {
            URLClassLoader classLoader = new URLClassLoader(new URL[] {new File(pathToClass).toURI().toURL()});
            Class<?> clazz = classLoader.loadClass(className);
            result = runner.run(clazz);
            classLoader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Result runTestByClass(Class<?> clazz) {
        return runner.run(clazz);
    }

    public List<Result> runTestsByClassNames(List<String> classNames, String pathToClass) {
        Result result;
        List<Result> results = new ArrayList<>();
        try (URLClassLoader classLoader = new URLClassLoader(new URL[] {new File(pathToClass).toURI().toURL()})) {
            for (String className : classNames) {
                Class<?> clazz = classLoader.loadClass(className);
                result = runner.run(clazz);
                results.add(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    public Result runTestsByClasses(Class<?>... classes) {
        return runner.run(classes);
    }

    public Result runTestsByPackage(String packageName) {
        Result result = null;
        List<Class<?>> testClasses = new ArrayList<>();
        File folder = new File(packageName);
        File[] files = folder.listFiles();
        for (File file : files) {
            String fileName = file.getName();
            if (fileName.endsWith(".java") && fileName.endsWith("Test.java")) {
                String className = fileName.substring(0, fileName.lastIndexOf("."));
                try {
                    Class<?> cls = Class.forName(className);
                    testClasses.add(cls);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        for (Class<?> cls : testClasses) {
            result = runTestByClass(cls);
        }
        return result;
    }
}

