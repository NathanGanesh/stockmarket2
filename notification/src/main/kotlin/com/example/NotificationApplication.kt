package com.example

import com.example.notification.NotificationConfig
import com.example.rabbitamqp.RabbitMQMessageProducerToBeDeleted
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.context.annotation.Bean

@SpringBootApplication(
    scanBasePackages = ["com.example.*", "com.example.rabbitamqp"]
)
@EnableEurekaClient
class NotificationApplication

    fun main(args: Array<String>) {
        runApplication<NotificationApplication>(*args)
    }



@Bean
fun init(rabbitMqMessageProducer: RabbitMQMessageProducerToBeDeleted, notificationConfig: NotificationConfig) = CommandLineRunner { (args) ->
    run {
        rabbitMqMessageProducer.publish(
            "foo", notificationConfig.internalExchange,
            notificationConfig.internalNotificationRoutingKey
        )
    }
}