package com.shoshin.data.entities.review

import com.shoshin.domain.common.Mapper
import com.shoshin.domain.entities.Review

class ReviewRemoteToReviewMapper: Mapper<ReviewRemote, Review>() {
    override fun map(from: ReviewRemote): Review {
        return Review(
            title = from.displayTitle ?: "No title",
            description = from.summaryShort ?: "",
            imageUrl = from.multimedia?.src,
            articleUrl = from.link?.url
        )
    }
}