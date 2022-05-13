package com.newcore.cleanarchitecturecryptocurrency.di

import com.newcore.cleanarchitecturecryptocurrency.common.Constants.BASE_URL
import com.newcore.cleanarchitecturecryptocurrency.data.remote.CoinApi
import com.newcore.cleanarchitecturecryptocurrency.data.repository.CoinRepository
import com.newcore.cleanarchitecturecryptocurrency.domain.repository.ICoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun getCoinApi(): CoinApi = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CoinApi::class.java)

    @Provides
    @Singleton
    fun getCoinRepository(coinApi: CoinApi): ICoinRepository = CoinRepository(coinApi)
}