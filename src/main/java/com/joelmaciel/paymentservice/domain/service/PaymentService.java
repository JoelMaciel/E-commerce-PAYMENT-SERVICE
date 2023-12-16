package com.joelmaciel.paymentservice.domain.service;

import com.joelmaciel.paymentservice.domain.entity.TransactionDetails;
import com.joelmaciel.paymentservice.domain.model.PaymentRequest;
import com.joelmaciel.paymentservice.domain.model.TransactionDetailsDTO;

import java.util.UUID;

public interface PaymentService {
    TransactionDetailsDTO savePayment(PaymentRequest paymentRequest);

    TransactionDetailsDTO detailsByOrderId(UUID orderId);
    TransactionDetails findByOrderId(UUID orderId);
}
