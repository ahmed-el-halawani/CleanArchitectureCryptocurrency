package com.newcore.cleanarchitecturecryptocurrency.presintation.ui.coins_list

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.newcore.cleanarchitecturecryptocurrency.databinding.FragmentCoinsListBinding
import com.newcore.cleanarchitecturecryptocurrency.presintation.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoinsListFragment :
    BaseFragment<FragmentCoinsListBinding>(FragmentCoinsListBinding::inflate) {

    private val vm: CoinsListFragmentViewModel by viewModels()

    private val coinsListAdapter: CoinListAdapter by lazy {
        CoinListAdapter().apply {
            onCoinClicked = {
                findNavController().navigate(
                    CoinsListFragmentDirections.actionCoinsListFragmentToCoinFragment(it.id)
                )
            }
        }
    }

    private fun initRecycler() = binding.apply {
        rvCoinsList.apply {
            adapter = coinsListAdapter
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false,
            )
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()

        vm.stateLiveData.observe(viewLifecycleOwner) { state ->
            binding.apply {
                if (state.error.isNotBlank()) tvError.text = state.error
                tvError.isVisible = state.error.isNotBlank()

                pbLoading.isVisible = state.isLoading

                coinsListAdapter.listOfCoins = state.coins
            }

        }

    }
}

