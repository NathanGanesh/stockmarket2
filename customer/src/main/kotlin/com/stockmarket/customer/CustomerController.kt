package com.stockmarket.customer

import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/customers")
@Slf4j
class CustomerController(val customerService: CustomerService) {
    //    private val log = Logger()
    companion object {
        private val logger = LoggerFactory.getLogger(CustomerController::class.java)
    }

    @PostMapping
    fun registerCustomer(@RequestBody customerRequest: CustomerRegistrationDto) {
        logger.info("new customer registration {}", customerRequest)
        customerService.registerCustomer(customerRequest)
    }
}