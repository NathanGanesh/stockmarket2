package com.stockmarket.customer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity

@Service
class CustomerService(
    @Autowired private val customerRepository: CustomerRepository,
    private val restTemplate: RestTemplate
) {
    fun registerCustomer(customerRegistrationDto: CustomerRegistrationDto) {
        val customer: Customer = Customer()
        customer.email = customerRegistrationDto.email
        customer.lastName = customerRegistrationDto.lastName
        customer.firstName = customerRegistrationDto.firstName
        customerRepository.saveAndFlush(customer).let { it ->
//            restTemplate.getForEntity("", FraudCheckResponse::class, it.id, "asd")
            var a: FraudCheckResponse? =
                restTemplate.getForObject(/* url = */ "http://localhost:8081/api/v1/fraud-check/{customerId}", /* responseType = */
                    FraudCheckResponse::class.java, /* ...uriVariables = */
                    it.id
                )
            // TODO: 11/05/2022  chain is isfraudster throw illegalstateexception
            print(a)
//            
//                .also {
//                it?.isFraudster().let { 
//                    throw IllegalStateException("illegal state")
//                }
        }
    }
    // if is

}
