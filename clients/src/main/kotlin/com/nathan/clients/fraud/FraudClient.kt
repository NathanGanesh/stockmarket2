package com.nathan.clients.fraud

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(
   name = "fraud",
    url= "${clients.fraud.url}"
)
interface FraudClient {

    @GetMapping(path = ["/{customerId}"])
    fun isFraudster(
        @PathVariable("customerId") customerId: Int
    ): FraudCheckResponse
}