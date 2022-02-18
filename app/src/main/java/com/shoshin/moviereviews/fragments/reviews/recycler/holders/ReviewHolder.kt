package com.shoshin.moviereviews.fragments.reviews.recycler.holders

import androidx.recyclerview.widget.RecyclerView
import com.shoshin.domain.entities.Review
import com.shoshin.moviereviews.databinding.ReviewHolderBinding
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation

class ReviewHolder(
    private val binding: ReviewHolderBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(review: Review) = with(binding) {
        title.text = review.title
        description.text = review.description
        if(review.imageUrl != null && review.imageUrl!!.isNotEmpty()) {
            val transformation = RoundedCornersTransformation(
                8,
                0,
                RoundedCornersTransformation.CornerType.ALL
            )
            Picasso.get()
                .load(review.imageUrl)
                .centerCrop()
                .resize(140, 140)
                .transform(transformation)
                .into(image)
        }
    }
}