package com.newcore.cleanarchitecturecryptocurrency.presintation.ui.coins_list

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.newcore.cleanarchitecturecryptocurrency.databinding.ItemCoinsItemBinding
import com.newcore.cleanarchitecturecryptocurrency.domain.model.Coin

class CoinListAdapter : RecyclerView.Adapter<CoinListAdapter.CoinListViewHolder>() {
    var onCoinClicked: ((Coin) -> Unit)? = null

    var listOfCoins = emptyList<Coin>()
        set(value) {
            field = value
            notifyItemRangeChanged(0, value.size)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinListViewHolder {
        return CoinListViewHolder(
            ItemCoinsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CoinListViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = listOfCoins.size

    @SuppressLint("SetTextI18n")
    inner class CoinListViewHolder(private val binding: ItemCoinsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            binding.apply {
                listOfCoins[position].apply {
                    tvCoinName.text = "$rank. $name$symbol"
                    tvIsActive.text = if (isActive) "active" else "inactive"
                    tvIsActive.setTextColor(if (isActive) Color.GREEN else Color.RED)
                    rowCoin.setOnClickListener { onCoinClicked?.invoke(this) }
                }
            }
        }
    }
}


