package com.cerengumus.bitcointrackerapp.ui.favourite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.cerengumus.bitcointrackerapp.R
import com.cerengumus.bitcointrackerapp.adapters.CoinsListAdapter
import com.cerengumus.bitcointrackerapp.adapters.OnItemClickCallback
import com.cerengumus.bitcointrackerapp.core.common.MainNavigationFragment
import com.cerengumus.bitcointrackerapp.databinding.FragmentFavouriteScreenBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavouriteScreenFragment : MainNavigationFragment(), OnItemClickCallback {

    private val viewModel: FavouriteScreenViewModel by viewModel()
    private lateinit var _binding: FragmentFavouriteScreenBinding
    private val binding: FragmentFavouriteScreenBinding get() = _binding!!
    private var favouritesAdapter = CoinsListAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavouriteScreenBinding.inflate(inflater)

        observeViewModel()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews()
    }


    override fun initializeViews() {
        binding.favouritesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = favouritesAdapter
        }
    }

    override fun observeViewModel() {
        viewModel.favoriteCoinsList.observe(viewLifecycleOwner, {
            favouritesAdapter.updateList(it)

            if (it.isEmpty()) {
                viewModel.isFavouritemsEmpty(true)
                binding.noFavouritesView.isVisible = false
            } else {
                binding.noFavouritesView.isVisible = true
            }

        })

        viewModel.toastError.observe(viewLifecycleOwner, {
            showToast(it)
        })

        viewModel.favouriteStock.observe(viewLifecycleOwner, {
            if (it != null) {
                showToast(
                    getString(if (it.isFavourite) R.string.added_to_favourite else R.string.removed_to_favourite).format(
                        it.symbol
                    )
                )
            }
        })
    }

    override fun onItemClick(symbol: String, id: String) {
        requireActivity().run {
        }

    }

    override fun onFavouriteClicked(symbol: String) {
        viewModel.updateFavouriteStatus(symbol)
    }
}