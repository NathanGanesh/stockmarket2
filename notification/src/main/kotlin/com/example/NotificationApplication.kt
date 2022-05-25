package com.example

import com.example.notification.NotificationConfig
import com.example.rabbitamqp.RabbitMqMessageProducer
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.context.annotation.Bean

@SpringBootApplication(
    scanBasePackages = ["com.example.notification", "com.example.rabbitamqp"]
)
@EnableEurekaClient
class NotificationApplication{


//@Bean
//fun init(rabbitMqMessageProducer: RabbitMqMessageProducer, notificationConfig: NotificationConfig) = CommandLineRunner {
//        rabbitMqMessageProducer.publish(
//            "foo", notificationConfig.internalExchange,
//            notificationConfig.internalNotificationRoutingKey
//        )
//}

}
fun main(args: Array<String>) {
    runApplication<NotificationApplication>(*args)
}

