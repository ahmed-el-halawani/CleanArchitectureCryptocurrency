package com.newcore.cleanarchitecturecryptocurrency.domain.model

data class Coin(
    var id: String,
    var isActive: Boolean,
    var name: String,
    var rank: Int,
    var symbol: String,
)

