package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentService {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    @Value(value = "${message.topic.private.name}")
    private String privateTopicName;

    public void enroll(String key, User user) {
        kafkaTemplate.send(privateTopicName, key, user);
    }

}
