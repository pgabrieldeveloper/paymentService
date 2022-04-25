package com.example.paymenteserviceconsumer.config

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.converter.JsonMessageConverter

@Configuration
class JsonConsumerConfig(val properties:KafkaProperties) {

    @Bean
    fun jsonConsumerFactory(): ConsumerFactory<String,Any> {
        var configs = HashMap<String, Any>()
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.bootstrapServers)
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer")
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer")
        return DefaultKafkaConsumerFactory(configs)

    }

    @Bean
    fun jsonContainerFactory(jsonConsumerFactory: ConsumerFactory<String,Any>): ConcurrentKafkaListenerContainerFactory<String,Any> {
        var factory = ConcurrentKafkaListenerContainerFactory<String, Any>()
        factory.consumerFactory = jsonConsumerFactory
        factory.setMessageConverter(JsonMessageConverter())
        return factory
    }

}