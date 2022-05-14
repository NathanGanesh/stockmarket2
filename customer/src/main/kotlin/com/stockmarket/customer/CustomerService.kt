package com.stockmarket.customer

import com.nathan.clients.fraud.FraudCheckResponse
import com.nathan.clients.fraud.FraudClient
import com.nathan.clients.notification.NotificationClient
import com.nathan.clients.notification.NotificationRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity

@Service
class CustomerService(
    private val customerRepository: CustomerRepository,
   private val fraudClient: FraudClient,
   private val notificationClient: NotificationClient
) {
    fun registerCustomer(customerRegistrationDto: CustomerRegistrationDto) {
        val customer: Customer = Customer()
        customer.email = customerRegistrationDto.email
        customer.lastName = customerRegistrationDto.lastName
        customer.firstName = customerRegistrationDto.firstName
        customerRepository.saveAndFlush(customer).let { it ->
            it.id.let {  it1 ->
                it1?.let { it2 -> fraudClient.isFraudster(it2).let { fraudCheckResponse ->
                    if(fraudCheckResponse.isFraudster == true){
                        throw IllegalStateException("fraudster")
                    }else{
                        notificationClient.sendNotification(NotificationRequest(
                            message = "welcome to stockmarket " + customer.firstName,
                            toCustomerId = it1,
                            toCustomerName = customer.email
                        ))
                    }
                } }
            }

//            var fraudCheckResponse:FraudCheckResponse = it.id?.let { it1 -> fraudClient.isFraudster(it1) }.let!!
        }
    }
}
