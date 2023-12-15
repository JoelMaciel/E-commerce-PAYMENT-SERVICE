package com.joelmaciel.paymentservice.domain.model;

import com.joelmaciel.paymentservice.domain.entity.TransactionDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDetailsDTO {

    private UUID transactionId;
    private UUID orderId;
    private String paymentMode;
    private String referenceNumber;
    private Instant paymentDate;
    private String status;
    private BigDecimal amount;

    public static TransactionDetailsDTO toDTO(TransactionDetails transactionDetails) {
        return TransactionDetailsDTO.builder()
                .transactionId(transactionDetails.getTransactionId())
                .orderId(transactionDetails.getOrderId())
                .paymentMode(transactionDetails.getPaymentMode())
                .referenceNumber(transactionDetails.getReferenceNumber())
                .paymentDate(transactionDetails.getPaymentDate())
                .status(transactionDetails.getStatus())
                .amount(transactionDetails.getAmount())
                .build();
    }
}
