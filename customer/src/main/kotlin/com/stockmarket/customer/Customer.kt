package com.stockmarket.customer

import javax.persistence.*

@Entity
class Customer(

) {
    @SequenceGenerator(
        name = "customer_id_sequence",
        sequenceName = "customer_id_sequence"
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "customer_id_sequence"
    )
    @Id
    val id: Long? = null
    var email: String? = null
    var firstName: String? = null
    var lastName: String? = null
}
