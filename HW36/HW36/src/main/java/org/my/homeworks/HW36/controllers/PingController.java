package org.my.homeworks.HW36.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    private static final Logger logger = LoggerFactory.getLogger(PingController.class);

    @GetMapping("/ping")
    public String ping() {
        logger.info("Ping is ok");
        return "ОК";
    }
}