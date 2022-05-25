package com.stockmarket.customer

import com.example.rabbitamqp.RabbitMqMessageProducer
import com.nathan.clients.fraud.FraudClient
import com.nathan.clients.notification.NotificationRequest
import lombok.AllArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerService (
    private val customerRepository: CustomerRepository,
   private val fraudClient: FraudClient,
    private val rabbitMQMessageProducer: RabbitMqMessageProducer
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
                        val notification = NotificationRequest(
                            message = "welcome to stockmarket " + customer.firstName,
                            toCustomerId = it1,
                            toCustomerName = customer.email
                        )
                        rabbitMQMessageProducer.publish(notification,
                            "internal.exchange",
                        "internal.notification.routing-key")

                    }
                } }
            }

//            var fraudCheckResponse:FraudCheckResponse = it.id?.let { it1 -> fraudClient.isFraudster(it1) }.let!!
        }
    }
}
