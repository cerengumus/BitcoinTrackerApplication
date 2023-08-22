package com.cerengumus.bitcointrackerapp.adapters

import androidx.recyclerview.widget.DiffUtil
import com.cerengumus.bitcointrackerapp.data.local.database.CoinsListEntity

object CoinDiffCallback : DiffUtil.ItemCallback<CoinsListEntity>() {
    override fun areItemsTheSame(oldItem: CoinsListEntity, newItem: CoinsListEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CoinsListEntity, newItem: CoinsListEntity): Boolean {
        return oldItem == newItem
    }
}
