package org.my.homework;

import org.my.homework.configuration.MyConfiguration;
import org.my.homework.services.ConsoleCartService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConsoleCartApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(MyConfiguration.class);
        annotationConfigApplicationContext.refresh();

        ConsoleCartService consoleCartService = annotationConfigApplicationContext.getBean("consoleCartService", ConsoleCartService.class);
        consoleCartService.run();
        annotationConfigApplicationContext.close();
    }
}