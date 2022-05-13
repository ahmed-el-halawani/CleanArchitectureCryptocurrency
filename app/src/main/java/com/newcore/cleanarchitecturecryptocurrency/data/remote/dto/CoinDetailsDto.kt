package com.newcore.cleanarchitecturecryptocurrency.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.newcore.cleanarchitecturecryptocurrency.domain.model.CoinDetails

data class CoinDetailsDto(
    @SerializedName("description")
    var description: String,
    @SerializedName("development_status")
    var developmentStatus: String,
    @SerializedName("first_data_at")
    var firstDataAt: String,
    @SerializedName("hardware_wallet")
    var hardwareWallet: Boolean,
    @SerializedName("hash_algorithm")
    var hashAlgorithm: String,
    @SerializedName("id")
    var id: String,
    @SerializedName("is_active")
    var isActive: Boolean,
    @SerializedName("is_new")
    var isNew: Boolean,
    @SerializedName("last_data_at")
    var lastDataAt: String,
    @SerializedName("links")
    var links: Links,
    @SerializedName("links_extended")
    var linksExtended: List<LinksExtended>,
    @SerializedName("message")
    var message: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("open_source")
    var openSource: Boolean,
    @SerializedName("org_structure")
    var orgStructure: String,
    @SerializedName("proof_type")
    var proofType: String,
    @SerializedName("rank")
    var rank: Int,
    @SerializedName("started_at")
    var startedAt: String,
    @SerializedName("symbol")
    var symbol: String,
    @SerializedName("tags")
    var tags: List<Tag>,
    @SerializedName("team")
    var team: List<TeamMember>,
    @SerializedName("type")
    var type: String,
    @SerializedName("whitepaper")
    var whitepaper: Whitepaper,
)

fun CoinDetailsDto.toCoinDetails() = CoinDetails(
    description, id, isActive, name, rank, symbol, tags.map { it.name }, team
)