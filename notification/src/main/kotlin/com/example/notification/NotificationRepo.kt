package com.example.notification

import org.springframework.data.jpa.repository.JpaRepository

interface NotificationRepo  : JpaRepository<Notification, Int> {
}