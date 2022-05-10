package com.nathan.fraud

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class FraudCheckHistory(
    @SequenceGenerator(name = "fraud_id_sequence", sequenceName = "fraud_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fraud_id_sequence")
    @Id
    val id: Long? = null
) {

    private val customerId: Int? = null
    private val isFraudster: Boolean? = null
    private val createdAt: LocalDateTime? = null

}