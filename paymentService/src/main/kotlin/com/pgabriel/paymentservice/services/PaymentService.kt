package com.pgabriel.paymentservice.services

import com.pgabriel.paymentservice.DTOs.PaymentRequest

interface PaymentService {
    fun sendPayment(paymentRequest: PaymentRequest);
}