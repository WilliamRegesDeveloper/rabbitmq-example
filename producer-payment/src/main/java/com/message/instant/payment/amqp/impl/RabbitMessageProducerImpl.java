package com.message.instant.payment.amqp.impl;

import com.message.instant.payment.amqp.MessageProducer;
import com.message.instant.payment.dto.Payment;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitMessageProducerImpl implements MessageProducer<Payment> {

    @Value("${spring.rabbitmq.exchange.producer}")
    private String exchange;

    @Value("${spring.rabbitmq.router-key.producer}")
    private String routerProducer;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(Payment payment) {
        try {
            rabbitTemplate.convertAndSend(exchange, routerProducer, payment);
        } catch (Exception e) {
            throw new AmqpRejectAndDontRequeueException(e);
        }

    }
}
