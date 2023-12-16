package com.joelmaciel.paymentservice.domain.exception;

import java.util.UUID;

public class OrderIdNotFoundException extends EntityNotExistException {
    public OrderIdNotFoundException(String message) {
        super(message);
    }
    public OrderIdNotFoundException(UUID orderId) {
        this(String.format("There is no order with this id %s saved in the database", orderId));
    }
}
