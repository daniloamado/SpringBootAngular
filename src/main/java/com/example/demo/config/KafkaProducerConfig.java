package com.example.demo.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig {

//    @Value(value = "${spring.kafka.bootstrap-servers}")
//    private String bootstrapAddress;
//
//    @Bean
//    public ProducerFactory<String, User> producerFactoryEnrolment() {
//        Map<String, Object> configProps = new HashMap<>();
//        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress); // kafka admin bean
//        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//        return new DefaultKafkaProducerFactory<>(configProps);
//    }
//
//    @Bean
//    public KafkaTemplate<String, User> kafkaTemplateEnrolment() {
//        return new KafkaTemplate<>(producerFactoryEnrolment());
//    }

}
