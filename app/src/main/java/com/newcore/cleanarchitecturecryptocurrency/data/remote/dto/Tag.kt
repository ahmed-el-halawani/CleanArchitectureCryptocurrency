package com.newcore.cleanarchitecturecryptocurrency.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Tag(
    @SerializedName("coin_counter")
    var coinCounter: Int,
    @SerializedName("ico_counter")
    var icoCounter: Int,
    @SerializedName("id")
    var id: String,
    @SerializedName("name")
    var name: String
)