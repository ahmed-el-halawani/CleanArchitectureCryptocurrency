package com.newcore.cleanarchitecturecryptocurrency.presintation.ui.coin_details

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.newcore.cleanarchitecturecryptocurrency.databinding.FragmentCoinBinding
import com.newcore.cleanarchitecturecryptocurrency.presintation.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoinFragment : BaseFragment<FragmentCoinBinding>(FragmentCoinBinding::inflate) {

    private val vm: CoinFragmentViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.stateLiveData.observe(viewLifecycleOwner) { state ->
            binding.apply {

                dataGroup.isVisible = !state.isLoading
                pbLoading.isVisible = state.isLoading

                tvError.isVisible = state.error.isNotBlank()
                tvError.text = state.error

                state.coin?.let { it ->

                    TagsChipAdapter(ctGroup, it.tags).build()
                    tvDescription.text = it.description
                    lvTeam.adapter = ArrayAdapter(
                        requireContext(),
                        android.R.layout.simple_list_item_1,
                        it.team.map { member -> member.name },
                    )

                    tvCoinName.text = it.run { "$rank. $name $symbol" }
                    tvIsActive.text = if (it.isActive) "active" else "inactive"
                }
            }
        }
    }


}

