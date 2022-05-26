package com.example.rabbitmq

import com.example.notification.NotificationService
import com.nathan.clients.notification.NotificationRequest
import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component


@Component
@Slf4j
class NotificationConsumer(private val notificationService: NotificationService ) {
    companion object{
        private val log = LoggerFactory.getLogger(NotificationConsumer::class.java)
    }

    @RabbitListener(queues = ["\${rabbitmq.queues.notification}"])
    fun consumer(notificationRequest: NotificationRequest?) {
        log.info("Consumed {} from queue", notificationRequest)

        notificationRequest?.let { notificationService.send(it) }
    }
}
