package com.newjincin.starmap.dataprocessor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MessageProduceService {

    Logger logger = LoggerFactory.getLogger(getClass());

    public String produce() {
        String context = "hello " + new Date();
        logger.info("Produce: " + context);
        return context;
    }

}
