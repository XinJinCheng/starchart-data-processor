package com.newjincin.starmap.dataprocessor.app;

import com.newjincin.starmap.dataprocessor.service.MessageProcessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver1 {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MessageProcessService messageProcessService;

    @RabbitListener(queues = "newjincin.queue.message")
    public void receive(String hello) {
        logger.info("Receive: " + hello);
        messageProcessService.process((hello));
    }
}
