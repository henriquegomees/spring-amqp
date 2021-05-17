package com.hg.springamqp.config.amqp;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.hg.springamqp.constants.Queues.QUEUE;

@Configuration
public class QueueConfig {

    private final TopicExchange appExchange;

    @Autowired
    QueueConfig(TopicExchange exchange) {
        this.appExchange = exchange;
    }

    @Bean
    public Queue queue() {
        String emailQueueName = QUEUE.getQueueName();
        return new Queue(emailQueueName, true);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder
                .bind(queue())
                .to(appExchange)
                .with(QUEUE.getRoutingKey());
    }
}
