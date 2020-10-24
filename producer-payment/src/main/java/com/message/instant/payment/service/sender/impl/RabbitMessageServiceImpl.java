package com.message.instant.payment.service.sender.impl;

import com.message.instant.payment.amqp.MessageProducer;
import com.message.instant.payment.dto.Payment;
import com.message.instant.payment.service.sender.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMessageServiceImpl implements MessageService {

    @Autowired
    private MessageProducer<Payment> messageProducer;

    @Override
    public void sendMessage(Payment payment) {
        messageProducer.sendMessage(payment);
    }
}
