package com.newcore.cleanarchitecturecryptocurrency.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Stats(
    @SerializedName("contributors")
    var contributors: Int,
    @SerializedName("followers")
    var followers: Int,
    @SerializedName("stars")
    var stars: Int,
    @SerializedName("subscribers")
    var subscribers: Int
)