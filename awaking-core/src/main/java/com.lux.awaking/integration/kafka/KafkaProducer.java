package com.lux.pop.world.kafka;

import com.lux.pop.world.config.KafkaConfig;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducer {
    @Resource
    private KafkaConfig kafkaConfig;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        log.info(String.format("Send producing message: {}", message));
        kafkaTemplate.send(kafkaConfig.getPopWorldTestTopic(), message);
    }
}
