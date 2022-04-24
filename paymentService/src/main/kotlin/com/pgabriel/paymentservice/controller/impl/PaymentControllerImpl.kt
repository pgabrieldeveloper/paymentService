package com.pgabriel.paymentservice.controller.impl

import com.pgabriel.paymentservice.DTOs.PaymentRequest
import com.pgabriel.paymentservice.DTOs.PaymentResponse
import com.pgabriel.paymentservice.controller.PaymentController
import com.pgabriel.paymentservice.services.PaymentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("payment")
class PaymentControllerImpl(val paymentService: PaymentService):PaymentController {

    override fun payment(payment: PaymentRequest): ResponseEntity<PaymentResponse> {
        paymentService.sendPayment(payment)
        return ResponseEntity.status(HttpStatus.OK).build()
    }

}