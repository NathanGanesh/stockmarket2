package com.example.notification

import com.nathan.clients.notification.NotificationRequest
import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping


@Slf4j
@RequestMapping("api/v1/notification")
class NotificationController(private val notificationService: NotificationService) {
    companion object {
        private val log = LoggerFactory.getLogger(NotificationController::class.java)
    }

    @PostMapping
    fun sendNotification(@RequestBody notificationRequest: NotificationRequest?) {
        log.info("New notification... {}", notificationRequest)
        if (notificationRequest != null) {
            notificationService.send(notificationRequest)
        }
    }
}