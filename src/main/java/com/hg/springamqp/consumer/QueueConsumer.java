package com.hg.springamqp.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumer {

    Logger log = LoggerFactory.getLogger(QueueConsumer.class);

    private final static String QUEUE_NAME = "foo.bar";

    @RabbitListener(queues = QUEUE_NAME)
    public void onMessage(Message message) {
        String strMessage = new String(message.getBody());
        String routingKey = message.getMessageProperties().getReceivedRoutingKey();

        log.info("Message received: [{}] on routing key [{}]", strMessage, routingKey);
    }
}
