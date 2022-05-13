package com.newcore.cleanarchitecturecryptocurrency.domain.model


import com.google.gson.annotations.SerializedName
import com.newcore.cleanarchitecturecryptocurrency.data.remote.dto.Tag
import com.newcore.cleanarchitecturecryptocurrency.data.remote.dto.TeamMember

data class CoinDetails(
    var description: String,
    var id: String,
    var isActive: Boolean,
    var name: String,
    var rank: Int,
    var symbol: String,
    var tags: List<String>,
    var team: List<TeamMember>,
)