package com.stockmarket

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.PropertySource
import org.springframework.context.annotation.PropertySources


@EnableEurekaClient
@SpringBootApplication(scanBasePackages = ["com.stockmarket.customer", "com.example.rabbitamqp"])
@EnableFeignClients(
    basePackages = ["com.nathan.clients"]
)
//"classpath:app-${spring.profiles.active}.properties"
@PropertySources(
  PropertySource("classpath:clients-kube.properties")
//    PropertySource("classpath:-" + "${spring.profiles.active }" + ".properties")
)
class CustomerApplication

fun main(args: Array<String>) {
    runApplication<CustomerApplication>(*args)
}
