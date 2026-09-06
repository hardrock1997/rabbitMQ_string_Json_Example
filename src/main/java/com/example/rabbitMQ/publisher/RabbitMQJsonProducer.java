package com.example.rabbitMQ.publisher;

import com.example.rabbitMQ.dto.Invoice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonProducer {

    @Value("${rabbitmq.queue.json.name}")
    private String queueJson;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key.json.name}")
    private String routingKeyJson;

    private RabbitTemplate rabbitTemplate;

    public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonProducer.class);

    public void sendJsonMessage(Invoice invoice) {
        LOGGER.info(String.format("Message send -> %s", invoice.toString()));
        rabbitTemplate.convertAndSend(exchange, routingKeyJson, invoice);
    }
}
