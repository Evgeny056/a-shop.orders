package com.ashoporders.config.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    private String newOrdersTopic = "new_orders";
    private String changeOrdersStatusTopic = "change_orders_status";
    private int numPartitions = 3;

    @Bean
    public NewTopic createOrderTopic() {
        return TopicBuilder.name(newOrdersTopic)
                .partitions(numPartitions)
                .replicas(1)
                .compact()
                .build();
    }

    @Bean
    public NewTopic changeOrdersStatusTopic() {
        return TopicBuilder
                .name(changeOrdersStatusTopic)
                .build();
    }
}
