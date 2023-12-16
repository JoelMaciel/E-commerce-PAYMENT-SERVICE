package com.joelmaciel.paymentservice.domain.service.impl;

import com.joelmaciel.paymentservice.domain.entity.TransactionDetails;
import com.joelmaciel.paymentservice.domain.exception.BusinessException;
import com.joelmaciel.paymentservice.domain.exception.OrderIdNotFoundException;
import com.joelmaciel.paymentservice.domain.model.PaymentRequest;
import com.joelmaciel.paymentservice.domain.model.TransactionDetailsDTO;
import com.joelmaciel.paymentservice.domain.repository.TransactionDetailsRepository;
import com.joelmaciel.paymentservice.domain.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final TransactionDetailsRepository transactionDetailsRepository;

    @Override
    @Transactional
    public TransactionDetailsDTO savePayment(PaymentRequest paymentRequest) {
        log.info("Recording Payment Details? {}", paymentRequest);
        TransactionDetails transactionDetails = PaymentRequest.toEntity(paymentRequest);

        log.info("Transaction Completed with uui: {}", transactionDetails.getTransactionId());
        return TransactionDetailsDTO.toDTO(transactionDetailsRepository.save(transactionDetails));
    }

    @Override
    @Transactional(readOnly = true)
    public TransactionDetailsDTO detailsByOrderId(UUID orderId) {
        log.info("Getting payment details for the Order id: {}", orderId);
        return TransactionDetailsDTO.toDTO(findByOrderId(orderId));
    }

    @Override
    @Transactional(readOnly = true)
    public TransactionDetails findByOrderId(UUID orderId) {
        try {
            return transactionDetailsRepository.findByOrderId(orderId);
        } catch (BusinessException e) {
            throw new OrderIdNotFoundException(orderId);
        }
    }
}
