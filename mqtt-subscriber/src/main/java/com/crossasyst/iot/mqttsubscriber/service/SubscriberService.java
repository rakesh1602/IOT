package com.crossasyst.iot.mqttsubscriber.service;

import lombok.extern.log4j.Log4j2;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class SubscriberService {

    private final MqttClient mqttClient;

    @Value("${mqtt.topic}")
    private String mqttTopic;

    @Autowired
    public SubscriberService(MqttClient mqttClient) {
        this.mqttClient = mqttClient;
    }

    @Scheduled(cron = "*/01 * * * * *")
    public void init() {
        try {
            mqttClient.subscribe(mqttTopic, (topic, message) -> {
                String payload = new String(message.getPayload());
                log.info("Received message from topic " + topic + ": " + payload);
            });
        } catch (MqttException e) {
            log.error("Failed to subscribe to the MQTT topic: {}", e.getMessage());
            throw new RuntimeException("Failed to subscribe to the MQTT topic", e);
        }
    }
}
