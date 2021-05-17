package com.hg.springamqp.config.amqp;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExchangeConfig {

    @Autowired
    private AmqpAdmin amqpAdmin;

    @Value("${rabbit.exchange}")
    private String appExchangeName;

    @Bean(name = "appExchange")
    public TopicExchange appExchange() {
        TopicExchange exchange = new TopicExchange(appExchangeName);

        amqpAdmin.declareExchange(exchange);

        return exchange;
    }

}
