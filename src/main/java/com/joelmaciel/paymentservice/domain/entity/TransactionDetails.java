package com.joelmaciel.paymentservice.domain.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "transaction_details")
public class TransactionDetails {

    @Id
    @Type(type = "uuid-char")
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID transactionId;
    @Type(type = "uuid-char")
    private UUID orderId;
    private String paymentMode;
    private String referenceNumber;
    private Instant paymentDate;
    private String status;
    private BigDecimal amount;
}
