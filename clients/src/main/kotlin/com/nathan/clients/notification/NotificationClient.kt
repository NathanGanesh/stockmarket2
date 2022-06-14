package com.nathan.clients.notification

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping

@FeignClient(
    name = "notification",
    url= "${clients.fraud.url}"
)
interface NotificationClient {
    @PostMapping()
    fun sendNotification(notificationRequest: NotificationRequest)
}