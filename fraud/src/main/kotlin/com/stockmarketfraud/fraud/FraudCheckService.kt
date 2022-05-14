package com.stockmarketfraud.fraud

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class FraudCheckService(@Autowired val fraudCheckHistoryRepository: FraudCheckHistoryRepository) {

    fun isFraudulentCustomer(customerId: Int): Boolean {
        val fraudCheckHistory: FraudCheckHistory = FraudCheckHistory()
        fraudCheckHistory.createdAt = (LocalDateTime.now())
        fraudCheckHistory.customerId = customerId
        fraudCheckHistory.isFraudster = false
        fraudCheckHistoryRepository.save(fraudCheckHistory)
        return false
    }
}