package org.my.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsoleCartApplication {

    @Autowired
    private ConsoleCartService consoleCartService;

    public static void main(String[] args) {
        SpringApplication.run(ConsoleCartApplication.class, args);
    }
}