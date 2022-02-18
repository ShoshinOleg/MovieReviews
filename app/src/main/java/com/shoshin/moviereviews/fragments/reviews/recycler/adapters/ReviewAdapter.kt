package com.shoshin.moviereviews.fragments.reviews.recycler.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.shoshin.domain.entities.Review
import com.shoshin.moviereviews.databinding.ReviewHolderBinding
import com.shoshin.moviereviews.fragments.reviews.recycler.holders.ReviewHolder

class ReviewAdapter: PagingDataAdapter<Review, ReviewHolder>(ReviewDiffCallback()) {
    override fun onBindViewHolder(holder: ReviewHolder, position: Int) {
        val review = getItem(position) ?: return
        holder.bind(review)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ReviewHolderBinding.inflate(inflater, parent, false)
        return ReviewHolder(binding)
    }
}