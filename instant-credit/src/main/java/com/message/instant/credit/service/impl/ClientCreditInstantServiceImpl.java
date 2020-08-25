package com.message.instant.credit.service.impl;

import com.message.instant.credit.dto.Payment;
import com.message.instant.credit.service.CreditInstantService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ClientCreditInstantServiceImpl implements CreditInstantService<Payment> {


    @Override
    public void creditInstant(Payment payment) throws Exception{
//        Preconditions
//                .checkArgument(
//                        isPaymentsGreaterThanZero(payment.getValue()));

        System.out.println(payment.getName());
        System.out.println(payment.getCpf());
        System.out.println(payment.getValue());
    }

    private boolean isPaymentsGreaterThanZero(BigDecimal value) {
        return value.compareTo(BigDecimal.ZERO) > 0;
    }
}
