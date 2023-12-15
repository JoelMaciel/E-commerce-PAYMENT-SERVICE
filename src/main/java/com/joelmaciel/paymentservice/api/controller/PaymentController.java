package com.joelmaciel.paymentservice.api.controller;

import com.joelmaciel.paymentservice.domain.model.TransactionDetailsDTO;
import com.joelmaciel.paymentservice.domain.model.PaymentRequest;
import com.joelmaciel.paymentservice.domain.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionDetailsDTO doPayment(@RequestBody @Valid PaymentRequest paymentRequest) {
        return paymentService.doPayment(paymentRequest);
    }
}
