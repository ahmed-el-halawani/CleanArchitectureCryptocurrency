package com.newcore.cleanarchitecturecryptocurrency.domain.repository

import com.newcore.cleanarchitecturecryptocurrency.data.remote.dto.CoinDetailsDto
import com.newcore.cleanarchitecturecryptocurrency.data.remote.dto.CoinDto

interface ICoinRepository {
    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(id: String): CoinDetailsDto
}