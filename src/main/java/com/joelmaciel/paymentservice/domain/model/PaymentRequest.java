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
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {

    private UUID orderId;
    private BigDecimal amount;
    private String referenceNumber;
    private PaymentMode paymentMode;

    public static TransactionDetails toEntity(PaymentRequest paymentRequest) {
        return TransactionDetails.builder()
                .orderId(paymentRequest.getOrderId())
                .paymentDate(Instant.now())
                .amount(paymentRequest.getAmount())
                .status("SUCCESS")
                .referenceNumber(paymentRequest.getReferenceNumber())
                .paymentMode(paymentRequest.getPaymentMode().name())
                .build();
    }
}
