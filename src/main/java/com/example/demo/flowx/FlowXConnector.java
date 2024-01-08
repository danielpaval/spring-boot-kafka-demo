package com.example.demo.flowx;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FlowXConnector {

    @KafkaListener(topics = "flowx")
    public void listen(ConsumerRecord<String, String> record) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        FlowXConnectorRequest request = objectMapper.readValue(record.value(), FlowXConnectorRequest.class);
        log.info("Received: {}", request);
    }

}
