package com.shoshin.data.sources

import com.shoshin.data.entities.review.ReviewRemote
import com.shoshin.data.entities.reviews_response.ReviewsResponse
import com.shoshin.data.interfaces.services.IReviewsService
import com.shoshin.data.interfaces.sources.IReviewRemoteSource
import com.shoshin.domain.common.Mapper
import com.shoshin.domain.entities.Review
import com.shoshin.domain.repositories.IApiKeyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ReviewRemoteSource @Inject constructor(
    private val service: IReviewsService,
    private val apiKeyRepository: IApiKeyRepository,
    private val responseToReviewsRemoteMapper: Mapper<ReviewsResponse, List<ReviewRemote>>,
    private val reviewRemoteToReviewMapper: Mapper<ReviewRemote, Review>
): IReviewRemoteSource {
    override suspend fun getReviews(offset: Int): List<Review> = withContext(Dispatchers.IO) {
        val reviewsRemote = responseToReviewsRemoteMapper.map(
            service.getReviews(apiKeyRepository.getApiKey(), offset)
        )
        return@withContext reviewRemoteToReviewMapper.map(reviewsRemote)
    }
}