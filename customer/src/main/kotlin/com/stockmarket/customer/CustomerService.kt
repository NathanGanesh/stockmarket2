package com.stockmarket.customer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerService(@Autowired private val customerRepository: CustomerRepository) {
    fun registerCustomer(customerRegistrationDto: CustomerRegistrationDto){
        val customer: Customer = Customer()
        customer.email = customerRegistrationDto.email
        customer.lastName = customerRegistrationDto.lastName
        customer.firstName = customerRegistrationDto.firstName
        customerRepository.save(customer)
    }
}