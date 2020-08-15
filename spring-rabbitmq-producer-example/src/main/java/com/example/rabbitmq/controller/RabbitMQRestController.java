package com.example.rabbitmq.controller;

import com.example.rabbitmq.model.License;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController

@RequestMapping(value = "/rabbitmq/")
public class RabbitMQRestController {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("licenseType") String licType, @RequestParam("licenseId") String licId, @RequestParam("licenseExpiry") LocalDate date) {

        License lic = new License();
        lic.setLicenseId(licId);
        lic.setLicenseType(licType);
        lic.setLiceneExpiry(date);

        amqpTemplate.convertAndSend("flexLicenseExchange", "flexLicense", lic);
        return "Message sent to the RabbitMQ Successfully";
    }

}
