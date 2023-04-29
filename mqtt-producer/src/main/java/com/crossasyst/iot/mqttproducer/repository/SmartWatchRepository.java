package com.crossasyst.iot.mqttproducer.repository;

import com.crossasyst.iot.mqttproducer.entity.SmartWatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartWatchRepository extends JpaRepository<SmartWatchEntity, Long> {
}
