package com.joelmaciel.paymentservice.api.controller;

import com.joelmaciel.paymentservice.domain.model.TransactionDetailsDTO;
import com.joelmaciel.paymentservice.domain.model.PaymentRequest;
import com.joelmaciel.paymentservice.domain.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping("/orders/{orderId}")
    public TransactionDetailsDTO getPaymentDetailsByOrderId(@PathVariable UUID orderId) {
        return paymentService.detailsByOrderId(orderId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionDetailsDTO doPayment(@RequestBody @Valid PaymentRequest paymentRequest) {
        return paymentService.savePayment(paymentRequest);
    }
}
