package com.crossasyst.iot.mqttpublisher.repository;

import com.crossasyst.iot.mqttpublisher.entity.SmartWatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartWatchRepository extends JpaRepository<SmartWatchEntity, Long> {
}
