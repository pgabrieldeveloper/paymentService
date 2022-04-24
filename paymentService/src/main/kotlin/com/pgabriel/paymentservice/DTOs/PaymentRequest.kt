package com.pgabriel.paymentservice.DTOs

data class PaymentRequest(var idUser:Long, var idProduct: Long, var cardNumbar:String) :java.io.Serializable