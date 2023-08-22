package com.cerengumus.bitcointrackerapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cerengumus.bitcointrackerapp.R
import com.cerengumus.bitcointrackerapp.data.local.database.CoinsListEntity
import com.cerengumus.bitcointrackerapp.databinding.CoinItemBinding
import com.cerengumus.bitcointrackerapp.util.UIHelper
import com.cerengumus.bitcointrackerapp.utils.ImageLoader
import com.cerengumus.bitcointrackerapp.utils.dollarString
import com.cerengumus.bitcointrackerapp.utils.emptyIfNull
import java.util.*
import kotlin.collections.ArrayList

interface OnItemClickCallback {
    fun onItemClick(symbol: String, id: String)
    fun onFavouriteClicked(symbol: String)
}

class CoinsListAdapter(private val onItemClickCallback: OnItemClickCallback) :
    RecyclerView.Adapter<CoinsListAdapter.CoinViewHolder>() {

    private var coinsList: ArrayList<CoinsListEntity> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CoinViewHolder(
            CoinItemBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.bind(coinsList[position], onItemClickCallback)
    }

    override fun getItemCount(): Int = coinsList.size

    fun updateList(list: List<CoinsListEntity>) {
        this.coinsList.clear()
        this.coinsList.addAll(list)
        notifyDataSetChanged()
    }

    class CoinViewHolder(
        private val binding: CoinItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(model: CoinsListEntity, onItemClickCallback: OnItemClickCallback) {
            binding.coinsItemSymbolTextView.text = model.symbol
            binding.coinsItemNameTextView.text = model.name.emptyIfNull()
            binding.coinsItemPriceTextView.text = model.price.dollarString()

            UIHelper.showChangePercent(binding.coinsItemChangeTextView, model.changePercent)

            binding.favouriteImageView.setImageResource(
                if (model.isFavourite) R.drawable.ic_baseline_favorite_24
                else R.drawable.ic_baseline_favorite_border_24
            )

            binding.favouriteImageView.setOnClickListener {
                onItemClickCallback.onFavouriteClicked(model.symbol)
            }

            ImageLoader.loadImage(binding.coinsItemImageView, model.image ?: "")

            binding.coinsItemMainLayout.setOnClickListener {
                onItemClickCallback.onItemClick(
                    model.symbol,
                    model.id ?: model.symbol
                )
            }
        }
    }
}