package com.crossasyst.iot.mqttproducer.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class SmartWatch extends MqttMessage {

    @NotBlank(message = "Username cannot be null or blank.")
    @Size(max = 10, message = "Username maximum size 10 character")
    private String userName;

    private Integer heartRate;

    private Integer oxygenLevel;

    private Integer steps;
}
