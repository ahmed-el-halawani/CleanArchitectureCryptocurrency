package com.newcore.cleanarchitecturecryptocurrency.presintation.ui.coin_details

import androidx.lifecycle.*
import com.newcore.cleanarchitecturecryptocurrency.common.Constants.COIN_ID
import com.newcore.cleanarchitecturecryptocurrency.common.Resources
import com.newcore.cleanarchitecturecryptocurrency.domain.usecases.GetCoinDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinFragmentViewModel @Inject constructor(
    private val getCoinDetailsUseCase: GetCoinDetailsUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _stateMutableLiveData = MutableLiveData(CoinState())
    val stateLiveData: LiveData<CoinState> = _stateMutableLiveData

    init {
        savedStateHandle.get<String>(COIN_ID)?.let { getCoin(it) }
    }

    private fun getCoin(coinId: String) {
        getCoinDetailsUseCase(coinId).onEach {
            _stateMutableLiveData.value = when (it) {
                is Resources.Error -> CoinState(error = it.message ?: "un expected error")
                is Resources.Loading -> CoinState(isLoading = true)
                is Resources.Success -> CoinState(coin = it.data)
            }
        }.launchIn(viewModelScope)
    }
}