package com.shoshin.moviereviews.fragments.reviews.recycler.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import com.shoshin.moviereviews.databinding.LoadStateHolderBinding
import com.shoshin.moviereviews.fragments.reviews.recycler.holders.LoadStateHolder
import com.shoshin.moviereviews.fragments.reviews.recycler.holders.TryAgainAction

class DefaultLoadStateAdapter(
    private val tryAgainAction: TryAgainAction
): LoadStateAdapter<LoadStateHolder>() {
    override fun onBindViewHolder(holder: LoadStateHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LoadStateHolderBinding.inflate(inflater, parent, false)
        return LoadStateHolder(binding, tryAgainAction)
    }
}