package com.message.instant.payment.configuration;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitProducerConfiguration {

    @Value("${spring.rabbitmq.exchange.producer}")
    private String exchange;

    @Value("${spring.rabbitmq.queue.producer}")
    private String queue;

    @Value("${spring.rabbitmq.queue.dead-letter}")
    private String queueDeadLetter;

    @Value("${spring.rabbitmq.router-key.producer}")
    private String routerProducer;

    @Value("${spring.rabbitmq.router-key.dead-letter}")
    private String routerDeadLetter;


    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    public Queue queueDeadLetter(){
        return QueueBuilder.durable(queueDeadLetter)
                .deadLetterExchange(exchange)
                .deadLetterRoutingKey(routerProducer)
                .build();
    }

    @Bean
    public Queue queue() {
        return QueueBuilder
                .durable(queue)
                .deadLetterExchange(exchange)
                .deadLetterRoutingKey(routerDeadLetter)
                .build();
    }

    @Bean
    public Binding binding() {
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with(routerProducer);
    }

    @Bean
    public Binding bindingDeadLetter() {
        return BindingBuilder
                .bind(queueDeadLetter())
                .to(exchange())
                .with(routerDeadLetter);
    }


}
