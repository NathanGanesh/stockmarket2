package com.stockmarketfraud.fraud

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class FraudCheckHistory(
    @SequenceGenerator(name = "fraud_id_sequence", sequenceName = "fraud_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fraud_id_sequence")
    @Id
    val id: Int? = null
) {
    var customerId: Int? = null
    var isFraudster: Boolean? = null
    var createdAt: LocalDateTime? = null
}