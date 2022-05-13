package com.newcore.cleanarchitecturecryptocurrency.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Whitepaper(
    @SerializedName("link")
    var link: String,
    @SerializedName("thumbnail")
    var thumbnail: String
)