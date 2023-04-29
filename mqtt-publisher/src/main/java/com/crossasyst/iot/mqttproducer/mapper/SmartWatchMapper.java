package com.crossasyst.iot.mqttproducer.mapper;

import com.crossasyst.iot.mqttproducer.entity.SmartWatchEntity;
import com.crossasyst.iot.mqttproducer.model.SmartWatch;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SmartWatchMapper {

    SmartWatchEntity modelToEntity(SmartWatch smartWatch);

    SmartWatch entityToModel(SmartWatchEntity smartWatchEntity);
}
