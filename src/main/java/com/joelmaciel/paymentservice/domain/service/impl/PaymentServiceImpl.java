package com.joelmaciel.paymentservice.domain.service.impl;

import com.joelmaciel.paymentservice.domain.entity.TransactionDetails;
import com.joelmaciel.paymentservice.domain.model.PaymentRequest;
import com.joelmaciel.paymentservice.domain.model.TransactionDetailsDTO;
import com.joelmaciel.paymentservice.domain.repository.TransactionDetailsRepository;
import com.joelmaciel.paymentservice.domain.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final TransactionDetailsRepository transactionDetailsRepository;

    @Override
    public TransactionDetailsDTO doPayment(PaymentRequest paymentRequest) {
        log.info("Recording Payment Details? {}", paymentRequest);
        TransactionDetails transactionDetails = PaymentRequest.toEntity(paymentRequest);
        log.info("Transaction Completed with uui: {}", transactionDetails.getTransactionId());
        return TransactionDetailsDTO.toDTO(transactionDetailsRepository.save(transactionDetails));
    }
}
