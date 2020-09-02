package com.message.instant.payment.controller;

import com.message.instant.payment.dto.Payment;
import com.message.instant.payment.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/payment")
public class PaymentController {

    @Autowired
    private MessageService messageService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/send")
    public void paymentInstant(@RequestBody Payment payment){
        messageService.sendMessage(payment);
    }
}
