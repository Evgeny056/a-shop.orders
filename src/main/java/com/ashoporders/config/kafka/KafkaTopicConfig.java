package com.ashoporders.config.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    private String newOrdersTopic = "new_orders";

    @Bean
    public NewTopic createOrderTopic() {
        return TopicBuilder.name(newOrdersTopic)
                .build();
    }
}
