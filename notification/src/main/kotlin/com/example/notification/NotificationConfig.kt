package com.example.notification

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class NotificationConfig {
    @Value("\${rabbitmq.exchanges.internal}")
    public val internalExchange: String? = null

    @Value("\${rabbitmq.queues.notification}")
    public val notificationQueue: String? = null

    @Value("\${rabbitmq.routing-keys.internal-notification}")
    public val internalNotificationRoutingKey: String? = null

    @Bean
    fun internalTopicExchange(): TopicExchange? {
        return TopicExchange(internalExchange)
    }

    @Bean
    fun notificationQueue(): Queue? {
        return Queue(notificationQueue)
    }

    @Bean
    fun internalToNotificationBinding(): Binding? {
        return BindingBuilder
            .bind(notificationQueue())
            .to(internalTopicExchange())
            .with(internalNotificationRoutingKey)
    }

}