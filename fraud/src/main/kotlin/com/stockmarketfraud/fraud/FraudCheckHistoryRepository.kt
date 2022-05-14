package com.stockmarketfraud.fraud

import org.springframework.data.jpa.repository.JpaRepository

interface FraudCheckHistoryRepository : JpaRepository<FraudCheckHistory, Int> {
}