package com.message.instant.payment.service.sender;

import com.message.instant.payment.dto.Payment;

public interface MessageService {

    public void sendMessage(Payment payment);
}
