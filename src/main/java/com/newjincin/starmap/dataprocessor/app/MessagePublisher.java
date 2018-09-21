package com.newjincin.starmap.dataprocessor.app;

import com.newjincin.starmap.dataprocessor.config.MessageQueueConfig;
import com.newjincin.starmap.dataprocessor.service.MessageProduceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class MessagePublisher implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Autowired
    private MessageProduceService messageProduceService;

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            logger.info("Publish a new topic1 message");
            String context = messageProduceService.produce();
            this.rabbitTemplate.convertAndSend(
                    MessageQueueConfig.exchangeName,
                    MessageQueueConfig.routingKey4topic1,
                    String.format("[%s] %s", MessageQueueConfig.topic1, context));
            Thread.sleep(2000);

            logger.info("Publish a new topic2 message");
            context = messageProduceService.produce();
            this.rabbitTemplate.convertAndSend(
                    MessageQueueConfig.exchangeName,
                    MessageQueueConfig.routingKey4topic2,
                    String.format("[%s] %s", MessageQueueConfig.topic2, context));
            Thread.sleep(2000);

            break;
        }
    }
}
