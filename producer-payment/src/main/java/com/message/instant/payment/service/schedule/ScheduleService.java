package com.message.instant.payment.service.schedule;

import com.message.instant.payment.dto.Payment;
import com.message.instant.payment.service.sender.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ScheduleService {

    @Autowired
    private MessageService messageService;

    @Scheduled(fixedDelay = 10 * 1000)
    public void sendMessage(){
        Payment payment = getPayment();
        messageService.sendMessage(payment);
    }

    private Payment getPayment() {
        Payment payment = new Payment();
        payment.setName("William");
        payment.setCpf("222.222.222.22");
        payment.setValue(
                new BigDecimal(
                        ThreadLocalRandom
                                .current()
                                .nextDouble(1.00, 100.00))
                        .setScale(2, RoundingMode.HALF_UP));
        return payment;
    }

}
