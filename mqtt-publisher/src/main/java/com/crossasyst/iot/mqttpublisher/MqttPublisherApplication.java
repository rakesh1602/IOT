package com.crossasyst.iot.mqttpublisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MqttPublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(MqttPublisherApplication.class, args);
	}

}
