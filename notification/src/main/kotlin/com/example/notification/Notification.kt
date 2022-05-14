package com.example.notification

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Notification(
    @Id
    @SequenceGenerator(
        name = "notification_id_sequence",
        sequenceName = "notification_id_sequence"
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "notification_id_sequence"
    )
    val id: Int? = null
) {
     var notificationId: Int? = null
     var toCustomer: Int? = null
     var toCustomerEmail: String? = null
     var sender: String? = null
     var message: String? = null
     var sentAt: LocalDateTime? = null
}