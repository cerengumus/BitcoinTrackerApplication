package com.cerengumus.bitcointrackerapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DividerItemDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.cerengumus.bitcointrackerapp.R
import com.cerengumus.bitcointrackerapp.adapters.CoinsListAdapter
import com.cerengumus.bitcointrackerapp.adapters.OnItemClickCallback
import com.cerengumus.bitcointrackerapp.core.common.MainNavigationFragment
import com.cerengumus.bitcointrackerapp.databinding.FragmentMainBinding

class MainFragment : MainNavigationFragment(), OnItemClickCallback {

    private val viewModel: MainViewModel by viewModel()

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding get() = _binding!!

    private var coinsListAdapter = CoinsListAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater)
        viewModel.loadCoinsFromApi()
        observeViewModel()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews()

    }

    override fun initializeViews() {
        binding.coinsListRecyclerView.adapter = coinsListAdapter
        val dividerItemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        binding.coinsListRecyclerView.addItemDecoration(dividerItemDecoration)
    }

    override fun observeViewModel() {
        viewModel.startTimer()
        viewModel.isLoading.observe(viewLifecycleOwner, {
            binding.coinsListLoading.visibility =
                if (viewModel.isListEmpty()) View.VISIBLE else View.GONE

            if (it) {
                binding.coinsListErrorView.visibility = View.GONE
            }
        })

        viewModel.coinsListData.observe(viewLifecycleOwner, {
            coinsListAdapter.updateList(it)
            binding.coinsListRecyclerView.isVisible = true
            binding.emptyGroup.isVisible = true
        })

        viewModel.favouriteStock.observe(viewLifecycleOwner, {
            it?.let {
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
            /*startActivity(
                Intent(this, ProjectProfileActivity::class.java)
                    .apply {
                        putExtra(Constants.EXTRA_SYMBOL, symbol)
                        putExtra(Constants.EXTRA_SYMBOL_ID, id)
                    }
            )*/
        }

    }

    override fun onFavouriteClicked(symbol: String) {
        viewModel.updateFavouriteStatus(symbol)
    }
}