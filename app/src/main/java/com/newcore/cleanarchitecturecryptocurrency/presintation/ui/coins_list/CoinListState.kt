package com.newcore.cleanarchitecturecryptocurrency.presintation.ui.coins_list

import com.newcore.cleanarchitecturecryptocurrency.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = "",
)