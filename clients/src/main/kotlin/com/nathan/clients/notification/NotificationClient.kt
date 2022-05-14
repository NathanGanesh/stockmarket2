package com.nathan.clients.notification

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping

@FeignClient("notification")
interface NotificationClient {
    @PostMapping("api/v1/notifcation")
    fun sendNotification(notificationRequest: NotificationRequest)
}