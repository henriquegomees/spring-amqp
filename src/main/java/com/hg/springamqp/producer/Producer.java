package com.hg.springamqp.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Autowired
    private RabbitTemplate template;

    @Value("${rabbit.exchange}")
    private String appExchange;

    public void send(String routingKey, String message) {
        template.convertAndSend(appExchange, routingKey, message);
    }
}
