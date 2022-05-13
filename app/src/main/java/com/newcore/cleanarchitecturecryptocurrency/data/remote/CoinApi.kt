package com.newcore.cleanarchitecturecryptocurrency.data.remote

import com.newcore.cleanarchitecturecryptocurrency.data.remote.dto.CoinDetailsDto
import com.newcore.cleanarchitecturecryptocurrency.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coin_id}")
    suspend fun getCoin(@Path("coin_id") coinId: String): CoinDetailsDto
}