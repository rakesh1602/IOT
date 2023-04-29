package com.crossasyst.iot.mqttpublisher.controller;

import com.crossasyst.iot.mqttpublisher.model.SmartWatch;
import com.crossasyst.iot.mqttpublisher.response.SmartWatchResponse;
import com.crossasyst.iot.mqttpublisher.service.SmartWatchService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Add records", description = "Adding records to the smart watch.")
@RestController
@RequestMapping(path = "v1")
public class SmartWatchController {

    private final SmartWatchService smartWatchService;

    @Autowired
    public SmartWatchController(SmartWatchService smartWatchService) {
        this.smartWatchService = smartWatchService;
    }

    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @PostMapping(path = "/datas", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SmartWatchResponse> recordData(@RequestBody SmartWatch smartWatch) throws MqttException {

        SmartWatchResponse smartWatchResponse = smartWatchService.recordData(smartWatch);

        return new ResponseEntity<>(smartWatchResponse, HttpStatus.OK);
    }
}
