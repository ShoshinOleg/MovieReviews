package com.shoshin.moviereviews.fragments.reviews.recycler.adapters

import androidx.recyclerview.widget.DiffUtil
import com.shoshin.domain.entities.Review

class ReviewDiffCallback: DiffUtil.ItemCallback<Review>() {
    override fun areItemsTheSame(oldItem: Review, newItem: Review): Boolean =
        oldItem.articleUrl == newItem.articleUrl

    override fun areContentsTheSame(oldItem: Review, newItem: Review): Boolean =
        oldItem == newItem
}