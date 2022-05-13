package com.newcore.cleanarchitecturecryptocurrency.presintation.ui.coin_details

import com.newcore.cleanarchitecturecryptocurrency.domain.model.CoinDetails

data class CoinState(
    val isLoading: Boolean = false,
    val coin: CoinDetails? = null,
    val error: String = "",
)