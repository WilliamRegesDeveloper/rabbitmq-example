package com.message.instant.payment.amqp;

public interface MessageProducer<T> {

    public void sendMessage(T t);
}
