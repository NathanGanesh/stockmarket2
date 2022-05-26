package com.example.notification

import com.nathan.clients.notification.NotificationRequest
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class NotificationService(private val notificationRepo: NotificationRepo) {

    fun send(notificationRequest: NotificationRequest){
        val notification: Notification = Notification()
        notification.toCustomer = notificationRequest.toCustomerId
        notification.toCustomerEmail = notificationRequest.toCustomerName
        notification.message = (notificationRequest.message)
        notification.sentAt = LocalDateTime.now()
        notification.sender = "stockmarket"

        notificationRepo.save(notification )
    }
}