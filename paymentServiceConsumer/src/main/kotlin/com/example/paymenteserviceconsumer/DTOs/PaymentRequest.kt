package com.pgabriel.paymentservice.DTOs

data class PaymentRequest(var idUser:Long, var idProduct: Long, var cardNumber:String) :java.io.Serializable