package com.newcore.cleanarchitecturecryptocurrency.presintation.ui.coin_details

import android.view.LayoutInflater
import com.google.android.material.chip.ChipGroup
import com.newcore.cleanarchitecturecryptocurrency.databinding.ItemCustomChipBinding

class TagsChipAdapter(private val chipGroup: ChipGroup, private val listOfTags: List<String>) {
    fun build() {
        chipGroup.apply {
            removeAllViews()
            listOfTags.forEach {
                addView(createChip(it))
            }
        }
    }

    private fun createChip(tag: String) = ItemCustomChipBinding.inflate(
        LayoutInflater.from(chipGroup.context), chipGroup, false
    ).chip.apply {
        text = tag
    }
}