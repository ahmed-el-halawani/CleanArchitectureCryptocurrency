package com.newcore.cleanarchitecturecryptocurrency.domain.usecases

import com.newcore.cleanarchitecturecryptocurrency.common.Resources
import com.newcore.cleanarchitecturecryptocurrency.data.remote.dto.toCoinDetails
import com.newcore.cleanarchitecturecryptocurrency.domain.model.CoinDetails
import com.newcore.cleanarchitecturecryptocurrency.domain.repository.ICoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinDetailsUseCase @Inject constructor(
    private val coinRepository: ICoinRepository,
) {
    operator fun invoke(coinId: String): Flow<Resources<CoinDetails>> = flow {
        try {
            emit(Resources.Loading())
            val coin = coinRepository.getCoinById(coinId)
            emit(Resources.Success(coin.toCoinDetails()))
        } catch (e: HttpException) {
            emit(Resources.Error(e.localizedMessage ?: "an unexpected Error"))
        } catch (io: IOException) {
            emit(Resources.Error("couldn't reach the server check internet connection"))

        }
    }
}