package com.pgabriel.paymentservice.services.impl

import com.pgabriel.paymentservice.DTOs.PaymentRequest
import com.pgabriel.paymentservice.services.PaymentService
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service

@Service
@Slf4j
class PaymentServiceImpl : PaymentService {

    override fun sendPayment(paymentRequest: PaymentRequest) {
        println("PAYMENT_SERVICE ::: RECEBI O PAGAMENTO: " + paymentRequest);
    }
}