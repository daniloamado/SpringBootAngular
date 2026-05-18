package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    @Value(value = "${message.topic.private.name}")
    private String privateTopicName;

//    @Bean
//    public NewTopic privateTopic() {
//        return TopicBuilder.name(privateTopicName)
//                .partitions(2)
//                .replicas(1)
//                .compact()
//                .build();
//    }

}
