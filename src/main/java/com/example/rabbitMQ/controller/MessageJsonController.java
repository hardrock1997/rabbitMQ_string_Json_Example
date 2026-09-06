package com.example.rabbitMQ.controller;


import com.example.rabbitMQ.dto.Invoice;
import com.example.rabbitMQ.publisher.RabbitMQJsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {
    private RabbitMQJsonProducer producer;

    public MessageJsonController(RabbitMQJsonProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestBody Invoice newInvoice) {
        producer.sendJsonMessage(newInvoice);
        return ResponseEntity.ok("Message published in JSON format");
    }
}
