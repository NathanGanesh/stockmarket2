package com.example.rabbitamqp

import lombok.AllArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.amqp.core.AmqpTemplate
import org.springframework.stereotype.Component


@Component
@Slf4j
@AllArgsConstructor
class RabbitMQMessageProducer {
    private val amqpTemplate: AmqpTemplate? = null
    companion object {
        private val logger = LoggerFactory.getLogger(RabbitMQMessageProducer::class.java)
    }
    fun publish(payload: Any?, exchange: String?, routingKey: String?) {
        logger.info(
            "Publishing to {} using routingKey {}. Payload: {}",
            exchange,
            routingKey,
            payload
        )
        amqpTemplate!!.convertAndSend(exchange, routingKey, payload)
        logger.info(
            "Published to {} using routingKey {}. Payload: {}",
            exchange,
            routingKey,
            payload
        )
    }
}