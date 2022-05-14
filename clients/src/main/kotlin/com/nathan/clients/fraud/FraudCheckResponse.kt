package com.nathan.clients.fraud

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Getter
import lombok.NoArgsConstructor

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
data class FraudCheckResponse( val isFraudster: Boolean? = false){

}