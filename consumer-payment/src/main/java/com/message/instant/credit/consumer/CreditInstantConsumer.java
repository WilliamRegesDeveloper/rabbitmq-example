package com.message.instant.credit.consumer;

import com.message.instant.credit.dto.Payment;
import com.message.instant.credit.service.CreditInstantService;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreditInstantConsumer {

    @Autowired
    private CreditInstantService<Payment> service;

    @RabbitListener(queues = {"${spring.rabbitmq.queue.producer}"})
    public void creditInstantListener(Payment payment) {
        try {
            service.creditInstant(payment);
        } catch (Exception e) {
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}
