package com.newcore.cleanarchitecturecryptocurrency.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("explorer")
    var explorer: List<String>,
    @SerializedName("facebook")
    var facebook: List<String>,
    @SerializedName("reddit")
    var reddit: List<String>,
    @SerializedName("source_code")
    var sourceCode: List<String>,
    @SerializedName("website")
    var website: List<String>,
    @SerializedName("youtube")
    var youtube: List<String>
)