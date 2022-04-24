package com.pgabriel.paymentservice.controller

import com.pgabriel.paymentservice.DTOs.PaymentRequest
import com.pgabriel.paymentservice.DTOs.PaymentResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

interface PaymentController {
    @PostMapping
    fun payment(@RequestBody payment:PaymentRequest): ResponseEntity<PaymentResponse>;
}