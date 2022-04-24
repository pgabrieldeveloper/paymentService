package com.pgabriel.paymentservice.config

import org.apache.kafka.clients.admin.AdminClientConfig
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder
import org.springframework.kafka.core.KafkaAdmin
import java.util.Objects

@Configuration
class KafkaAdminConfig(val properties: KafkaProperties) {

    @Bean
    fun kafkaAdmin():KafkaAdmin {
        var configs = HashMap<String,Any>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, properties.bootstrapServers);
        return KafkaAdmin(configs);
    }

    @Bean
    fun newTopics(): KafkaAdmin.NewTopics {
        return KafkaAdmin.NewTopics(
            TopicBuilder.name("payment-topic").partitions(1).build()
        )
    }

}