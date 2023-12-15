package com.joelmaciel.paymentservice.domain.service;

import com.joelmaciel.paymentservice.domain.model.PaymentRequest;
import com.joelmaciel.paymentservice.domain.model.TransactionDetailsDTO;

public interface PaymentService {
    TransactionDetailsDTO doPayment(PaymentRequest paymentRequest);
}
