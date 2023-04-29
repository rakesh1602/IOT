package com.crossasyst.iot.mqttpublisher.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "smart_watch")
public class SmartWatchEntity {

    @Id
    @SequenceGenerator(sequenceName = "watch_seq_id", name = "watch_seq_id", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "watch_seq_id")
    private Long watchId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "heart_rate")
    private Integer heartRate;

    @Column(name = "oxygen_level")
    private Integer oxygenLevel;

    @Column(name = "steps")
    private Integer steps;
}
