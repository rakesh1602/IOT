package com.crossasyst.iot.mqttpublisher.mapper;

import com.crossasyst.iot.mqttpublisher.entity.SmartWatchEntity;
import com.crossasyst.iot.mqttpublisher.model.SmartWatch;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SmartWatchMapper {

    SmartWatchEntity modelToEntity(SmartWatch smartWatch);

    SmartWatch entityToModel(SmartWatchEntity smartWatchEntity);
}
