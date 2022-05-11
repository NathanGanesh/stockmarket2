package com.stockmarket.customer

public class FraudCheckResponse(private val isFraudster: Boolean){

    fun isFraudster() : Boolean{
        return isFraudster;
    }
}