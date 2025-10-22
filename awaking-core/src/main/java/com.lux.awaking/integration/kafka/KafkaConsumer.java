package com.lux.pop.world.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {
    @KafkaListener(topics = "${kafka.testTopic}")
    public void receiveMessage(ConsumerRecord<String, String> record) {
        log.info("Received from topic:{} with message: {}", record.topic(), record.value());
    }
}
