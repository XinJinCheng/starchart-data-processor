package com.newjincin.starmap.dataprocessor.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageQueueConfig {

    public final static String prefix = "newjincin";
    public final static String topic1 = "message";
    public final static String topic2 = "messages";
    public final static String exchangeName = String.format("%s.exchange", prefix, prefix);
    public final static String queueName4topic1 = String.format("%s.queue.%s", prefix, topic1);
    public final static String queueName4topic2 = String.format("%s.queue.%s", prefix, topic2);
    public final static String routingKey4topic1 = String.format("%s.topic.%s", prefix, topic1);
    public final static String routingKey4topic2 = String.format("%s.topic.#", prefix);

    @Bean
    public Queue queueMessage() {
        return new Queue(queueName4topic1);
    }

    @Bean
    public Queue queueMessages() {
        return new Queue(queueName4topic2);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(exchangeName);
    }

    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with(routingKey4topic1);
    }

    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with(routingKey4topic2);
    }
}
