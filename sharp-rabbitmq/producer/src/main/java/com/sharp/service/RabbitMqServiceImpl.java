package com.sharp.service;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiap0308
 * @version v1.0.0
 * @since 2024-05-14 14:59:13
 */
@Service
public class RabbitMqServiceImpl implements RabbitMqService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessageByWork(String queue, Object msg) {
        rabbitTemplate.convertAndSend("", queue, msg);
    }

    @Override
    public void sendMessageByWork(String queue, Object msg, String ackId) {
        rabbitTemplate.convertAndSend("", queue, msg, new CorrelationData(ackId));
    }

    @Override
    public void sendMessageByExchange(String exchange, String routingKey, Object msg) {
        rabbitTemplate.convertAndSend(exchange, routingKey == null ? "" : routingKey, msg);
    }

    @Override
    public void sendMessageByExchange(String exchange, String routingKey, Object msg, String ackId) {
        rabbitTemplate.convertAndSend(exchange, routingKey == null ? "" : routingKey, msg, new CorrelationData(ackId));
    }
}
