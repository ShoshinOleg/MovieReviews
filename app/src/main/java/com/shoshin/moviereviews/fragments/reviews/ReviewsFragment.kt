package com.shoshin.moviereviews.fragments.reviews

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.shoshin.moviereviews.R
import com.shoshin.moviereviews.databinding.ReviewListFragmentBinding
import com.shoshin.moviereviews.fragments.reviews.recycler.adapters.DefaultLoadStateAdapter
import com.shoshin.moviereviews.fragments.reviews.recycler.adapters.ReviewAdapter
import com.shoshin.moviereviews.fragments.reviews.recycler.holders.LoadStateHolder
import com.shoshin.moviereviews.fragments.reviews.recycler.holders.TryAgainAction
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ReviewsFragment: Fragment(R.layout.review_list_fragment) {
    private val binding by viewBinding(ReviewListFragmentBinding::bind)
    private val viewModel: ReviewsViewModel by viewModels()
    private val adapter: ReviewAdapter by lazy { ReviewAdapter() }
    private lateinit var mainLoadStateHolder: LoadStateHolder

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupReviews()
        setupSwipeToRefresh()
        viewModel.getReviews()
    }

    private fun setupReviews() {
        val tryAgainAction: TryAgainAction = { adapter.retry() }
        val footerAdapter = DefaultLoadStateAdapter(tryAgainAction)
        val adapterWithLoadState = adapter.withLoadStateFooter(footerAdapter)

        binding.reviewsRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.reviewsRecyclerView.adapter = adapterWithLoadState

        mainLoadStateHolder = LoadStateHolder(
            binding.loadStateView,
            tryAgainAction,
            binding.swipeRefreshLayout
        )

        observeReviews()
        observeLoadState()
    }

    private fun setupSwipeToRefresh() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.getReviews()
        }
    }

    private fun observeReviews() {
        viewModel.reviews.observe(viewLifecycleOwner, { pagingData ->
            adapter.submitData(viewLifecycleOwner.lifecycle, pagingData)
        })
    }

    private fun observeLoadState() {
        viewLifecycleOwner.lifecycleScope.launch {
            adapter.loadStateFlow.collectLatest { state ->
                mainLoadStateHolder.bind(state.refresh)
            }
        }
    }
}