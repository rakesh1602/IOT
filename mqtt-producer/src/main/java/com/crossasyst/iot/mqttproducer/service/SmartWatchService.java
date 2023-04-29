package com.crossasyst.iot.mqttproducer.service;

import com.crossasyst.iot.mqttproducer.entity.SmartWatchEntity;
import com.crossasyst.iot.mqttproducer.mapper.SmartWatchMapper;
import com.crossasyst.iot.mqttproducer.model.SmartWatch;
import com.crossasyst.iot.mqttproducer.repository.SmartWatchRepository;
import com.crossasyst.iot.mqttproducer.response.SmartWatchResponse;
import lombok.extern.log4j.Log4j2;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class SmartWatchService {

    private final SmartWatchRepository smartWatchRepository;

    private final SmartWatchMapper smartWatchMapper;

    private final PublishService publishService;

    @Autowired
    public SmartWatchService(SmartWatchRepository smartWatchRepository, SmartWatchMapper smartWatchMapper, PublishService publishService) {
        this.smartWatchRepository = smartWatchRepository;
        this.smartWatchMapper = smartWatchMapper;
        this.publishService = publishService;
    }

    public SmartWatchResponse recordData(SmartWatch smartWatch) throws MqttException {

        log.info("Adding records to the database.");

        SmartWatchEntity smartWatchEntity=smartWatchMapper.modelToEntity(smartWatch);
        smartWatchRepository.save(smartWatchEntity);
        log.info("Records saved to the database.");

        SmartWatchResponse smartWatchResponse=new SmartWatchResponse();
        smartWatchResponse.setId(smartWatchEntity.getWatchId());
        log.info("Smart watch response id is {} ", smartWatchEntity.getWatchId());

        log.info("Calling mqtt publish service.");
        publishService.publish(smartWatchEntity.getWatchId());
        return smartWatchResponse;
    }
}
