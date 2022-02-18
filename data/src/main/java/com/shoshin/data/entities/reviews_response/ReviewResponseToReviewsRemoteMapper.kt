package com.shoshin.data.entities.reviews_response

import com.shoshin.data.entities.review.ReviewRemote
import com.shoshin.domain.common.Mapper

class ReviewResponseToReviewsRemoteMapper: Mapper<ReviewsResponse, List<ReviewRemote>>() {
    override fun map(from: ReviewsResponse): List<ReviewRemote> {
        return from.results ?: emptyList()
    }
}