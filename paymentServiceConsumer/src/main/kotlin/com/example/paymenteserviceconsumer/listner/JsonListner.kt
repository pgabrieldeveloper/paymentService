package com.example.paymenteserviceconsumer.listner

import com.pgabriel.paymentservice.DTOs.PaymentRequest
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class JsonListner {

    @KafkaListener(topics = ["payment-topic"] , groupId = "create-group", containerFactory = "jsonContainerFactory")
    fun antFraude(@Payload paymentRequest: PaymentRequest) {
        println("PAGAMENTO RECEBIFO ::: pagamento: " + paymentRequest)
        println("VALIDANDO FRAUD ::: validando...")
        Thread.sleep(1000)
        println("Compra Aprovada::: aprovada..")
        Thread.sleep(2000)

    }

    @KafkaListener(topics = ["payment-topic"] , groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    fun pdfGenerator() {
        println("Gerando PDF")
        Thread.sleep(3000)
        println("PDF GERADO")
        Thread.sleep(4000)

    }
    @KafkaListener(topics = ["payment-topic"] , groupId = "email-group", containerFactory = "jsonContainerFactory")
    fun SendEmail() {
        println("PREPARANDO EMAIL.")
        Thread.sleep(5000)
        println("EMAIL EVNAIDO")

    }

}