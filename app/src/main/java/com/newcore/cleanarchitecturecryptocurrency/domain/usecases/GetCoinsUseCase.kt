package com.newcore.cleanarchitecturecryptocurrency.domain.usecases

import com.newcore.cleanarchitecturecryptocurrency.common.Resources
import com.newcore.cleanarchitecturecryptocurrency.data.remote.dto.toCoin
import com.newcore.cleanarchitecturecryptocurrency.domain.model.Coin
import com.newcore.cleanarchitecturecryptocurrency.domain.repository.ICoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val coinRepository: ICoinRepository,
) {
    operator fun invoke(): Flow<Resources<List<Coin>>> = flow {
        try {
            emit(Resources.Loading())
            val list = coinRepository.getCoins()
            emit(Resources.Success(list.map { it.toCoin() }))
        } catch (e: HttpException) {
            emit(Resources.Error(e.localizedMessage ?: "an unexpected Error"))
        } catch (io: IOException) {
            emit(Resources.Error("couldn't reach the server check internet connection"))

        }
    }
}