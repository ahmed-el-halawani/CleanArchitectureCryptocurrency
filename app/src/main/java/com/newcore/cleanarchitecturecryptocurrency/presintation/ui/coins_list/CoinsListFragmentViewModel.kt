package com.newcore.cleanarchitecturecryptocurrency.presintation.ui.coins_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.newcore.cleanarchitecturecryptocurrency.common.Resources
import com.newcore.cleanarchitecturecryptocurrency.domain.usecases.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinsListFragmentViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase,
) : ViewModel() {

    private val _stateMutableLiveData = MutableLiveData(CoinListState())
    val stateLiveData: LiveData<CoinListState> = _stateMutableLiveData

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach {
            _stateMutableLiveData.value = when (it) {
                is Resources.Error -> CoinListState(error = it.message ?: "un expected error")
                is Resources.Loading -> CoinListState(isLoading = true)
                is Resources.Success -> CoinListState(coins = it.data ?: emptyList())
            }
        }.launchIn(viewModelScope)
    }

}