package com.nathan.clients.notification

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Getter
import lombok.NoArgsConstructor

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
data class NotificationRequest(
    val message: String? = "",
    val toCustomerId: Int? = null,
    val toCustomerName: String? = ""
) {

}
