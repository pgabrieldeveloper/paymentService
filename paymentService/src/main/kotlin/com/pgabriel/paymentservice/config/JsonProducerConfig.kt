package com.pgabriel.paymentservice.config

import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory
import org.springframework.kafka.support.serializer.JsonSerializer

@Configuration
class JsonProducerConfig(val properties:KafkaProperties) {

    @Bean
    fun jsonProducerFactory(): ProducerFactory<String, java.io.Serializable> {
        var configs  = HashMap<String, Any>()
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.bootstrapServers)
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer::class)
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer::class)
        return DefaultKafkaProducerFactory(configs, StringSerializer(), JsonSerializer())
    }

    @Bean
    fun jsonKafkaTemplate(jsonProducerFactory: ProducerFactory<String, java.io.Serializable>) : KafkaTemplate<String, java.io.Serializable>{
        return KafkaTemplate(jsonProducerFactory)
    }

}