package com.newcore.cleanarchitecturecryptocurrency.data.remote.dto


import com.google.gson.annotations.SerializedName

data class LinksExtended(
    @SerializedName("stats")
    var stats: Stats,
    @SerializedName("type")
    var type: String,
    @SerializedName("url")
    var url: String
)