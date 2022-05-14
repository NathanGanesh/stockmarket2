package com.stockmarket

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.ComponentScan


@EnableEurekaClient
@ComponentScan(basePackages = ["com.stockmarket.*"])
@EntityScan(basePackages = ["com.stockmarket.*"])
@SpringBootApplication
@EnableFeignClients(
    basePackages = ["com.nathan.clients"]
)
class CustomerApplication

fun main(args: Array<String>) {
    runApplication<CustomerApplication>(*args)
}
