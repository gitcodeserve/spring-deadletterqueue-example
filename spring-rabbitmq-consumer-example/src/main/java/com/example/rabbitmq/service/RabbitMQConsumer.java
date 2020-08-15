package com.example.rabbitmq.service;

import com.example.rabbitmq.exception.LicenseException;
import com.example.rabbitmq.model.License;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class RabbitMQConsumer {
    private static final Logger logger = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @RabbitListener(queues = "flex.queue")
    public void recievedMessage(License license) throws LicenseException {
        logger.info("Recieved Message From RabbitMQ: " + license);
        if ( license.getLiceneExpiry().isBefore(LocalDate.now())) {
            throw new LicenseException();
        }
    }

//    @RabbitListener(queues = "deadLetter.queue")
//    public void recievedDeadLetterMessage() throws LicenseException {
//        logger.info("Recieved Message From Dead letter queue: ");
//
//    }
}

