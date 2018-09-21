package com.newjincin.starmap.dataprocessor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MessageProcessService {

    Logger logger = LoggerFactory.getLogger(getClass());

    public void process(String hello) {
        logger.info("Process: " + hello);
    }


}
