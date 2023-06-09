package com.crossasyst.iot.mqttpublisher.service;

import com.crossasyst.iot.mqttpublisher.entity.SmartWatchEntity;
import com.crossasyst.iot.mqttpublisher.mapper.SmartWatchMapper;
import com.crossasyst.iot.mqttpublisher.model.SmartWatch;
import com.crossasyst.iot.mqttpublisher.repository.SmartWatchRepository;
import lombok.extern.log4j.Log4j2;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class PublishService {

    private final IMqttClient mqttClient;

    private final SmartWatchRepository smartWatchRepository;

    private final SmartWatchMapper smartWatchMapper;

    private final MqttMessage mqttMessage = new MqttMessage();

    @Value("${mqtt.topic}")
    private String topic;

    @Autowired
    public PublishService(IMqttClient mqttClient, SmartWatchRepository smartWatchRepository, SmartWatchMapper smartWatchMapper) {
        this.mqttClient = mqttClient;
        this.smartWatchRepository = smartWatchRepository;
        this.smartWatchMapper = smartWatchMapper;
    }

    public void publish(Long smartWatchId) throws MqttException {

        log.info("Retrieving smart watch records.");

        Optional<SmartWatchEntity> smartWatchEntity = Optional.ofNullable(smartWatchRepository.findById(smartWatchId)
                .orElseThrow(() -> new RuntimeException("Smart watch id not found {} " + smartWatchId)));

        if (smartWatchEntity.isPresent()) {
            SmartWatch smartWatch = smartWatchMapper.entityToModel(smartWatchEntity.get());
            log.info("Retrieved following details for smart watch id {} ", smartWatchId);

            log.info("Adding smart watch records to the mqtt payload.");
            mqttMessage.setPayload(smartWatch.toString().getBytes());
        }

        log.info("Publishing message to the mqtt topic");
        mqttClient.publish(topic, mqttMessage);
        log.info("Message published to the mqtt");
    }
}
