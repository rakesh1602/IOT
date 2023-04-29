package com.crossasyst.iot.mqttsubscriber.connection;

import lombok.extern.log4j.Log4j2;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Log4j2
public class MqttConfiguration {

    @Value("${mqtt.url}")
    private String brokerUrl;

    @Value("${mqtt.clientId}")
    private String clientId;

    @Bean
    public MqttClient mqttClient() throws RuntimeException {
        MqttClient mqttClient = null;

        try {
            mqttClient = new MqttClient(brokerUrl, clientId);
            mqttClient.connect();
        } catch (MqttException e) {
            log.error("Failed to connect to the MQTT broker: {}", e.getMessage());
            throw new RuntimeException("Failed to connect to the MQTT broker", e);
        }

        return mqttClient;
    }

}
