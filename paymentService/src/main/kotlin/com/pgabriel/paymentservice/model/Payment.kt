package com.pgabriel.paymentservice.model


data class Payment (var id: Long, var idUser:Long, var idProduct: Long, var cardNumbar:String) :java.io.Serializable