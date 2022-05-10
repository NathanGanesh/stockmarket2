package com.nathan

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["com.nathan.*"])
@EntityScan(basePackages = ["com.nathan.*"])
class FraudApplication

fun main(args: Array<String>) {
    runApplication<FraudApplication>(*args)
}
