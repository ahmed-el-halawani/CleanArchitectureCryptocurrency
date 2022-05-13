package com.newcore.cleanarchitecturecryptocurrency.data.remote.dto


import com.google.gson.annotations.SerializedName

data class TeamMember(
    @SerializedName("id")
    var id: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("position")
    var position: String
)