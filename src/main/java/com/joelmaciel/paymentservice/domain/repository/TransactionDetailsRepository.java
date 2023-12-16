package com.joelmaciel.paymentservice.domain.repository;

import com.joelmaciel.paymentservice.domain.entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails, UUID> {

    TransactionDetails findByOrderId(UUID orderId);
}
