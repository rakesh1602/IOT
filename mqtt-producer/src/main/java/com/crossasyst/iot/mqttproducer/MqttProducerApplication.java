package com.crossasyst.iot.mqttproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MqttProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MqttProducerApplication.class, args);
	}

}
