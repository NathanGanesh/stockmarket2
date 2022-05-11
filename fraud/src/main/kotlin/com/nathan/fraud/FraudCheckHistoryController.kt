package com.nathan.fraud

import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("api/v1/fraud-check")
@Slf4j
class FraudCheckHistoryController(private val fraudCheckService: FraudCheckService) {
    companion object {
        private val logger = LoggerFactory.getLogger(FraudCheckHistoryController::class.java)
    }
    @GetMapping(path = ["/{customerId}"])
    fun isFraudster(
        @PathVariable("customerId") customerId: Int?
    ): FraudCheckResponse? {
        val isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId!!)
        logger.info("fraud check request for customer {}", customerId)
        return FraudCheckResponse(isFraudulentCustomer)
    }
}