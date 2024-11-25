package br.com.scaa.infrastructure.messaging;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQPublisher {

    private final AmqpTemplate amqpTemplate;

    @Value("${rabbitmq.exchange.assinatura}")
    private String exchange;

    @Value("${rabbitmq.routingkey.assinatura}")
    private String routingKey;

    public RabbitMQPublisher(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void publishEvent(String message) {
        amqpTemplate.convertAndSend(exchange, routingKey, message);
    }
}
