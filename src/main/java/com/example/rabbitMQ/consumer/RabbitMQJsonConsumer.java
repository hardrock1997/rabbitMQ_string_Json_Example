package com.example.rabbitMQ.consumer;

import com.example.rabbitMQ.dto.Invoice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void consume(Invoice message) throws InterruptedException {
        LOGGER.info(String.format("Message received -> %s", message));
    }
}
