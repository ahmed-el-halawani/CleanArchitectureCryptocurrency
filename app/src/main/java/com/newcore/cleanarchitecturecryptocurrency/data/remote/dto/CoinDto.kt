package com.newcore.cleanarchitecturecryptocurrency.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.newcore.cleanarchitecturecryptocurrency.domain.model.Coin

data class CoinDto(
    @SerializedName("id")
    var id: String,
    @SerializedName("is_active")
    var isActive: Boolean,
    @SerializedName("is_new")
    var isNew: Boolean,
    @SerializedName("name")
    var name: String,
    @SerializedName("rank")
    var rank: Int,
    @SerializedName("symbol")
    var symbol: String,
    @SerializedName("type")
    var type: String,
)

fun CoinDto.toCoin() = Coin(
    id, isActive, name, rank, symbol
)