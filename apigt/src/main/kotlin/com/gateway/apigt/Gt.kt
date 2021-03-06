package com.gateway.apigt

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class Gt

fun main(args: Array<String>) {
    runApplication<Gt>(*args)
}
