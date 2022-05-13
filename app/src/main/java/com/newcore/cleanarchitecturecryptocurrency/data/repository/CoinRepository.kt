package com.newcore.cleanarchitecturecryptocurrency.data.repository

import com.newcore.cleanarchitecturecryptocurrency.data.remote.CoinApi
import com.newcore.cleanarchitecturecryptocurrency.data.remote.dto.CoinDetailsDto
import com.newcore.cleanarchitecturecryptocurrency.data.remote.dto.CoinDto
import com.newcore.cleanarchitecturecryptocurrency.domain.repository.ICoinRepository
import javax.inject.Inject

class CoinRepository @Inject constructor(
    val api: CoinApi,
) : ICoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(id: String): CoinDetailsDto {
        return api.getCoin(id)
    }
}