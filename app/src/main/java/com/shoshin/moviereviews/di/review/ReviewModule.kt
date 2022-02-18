package com.shoshin.moviereviews.di.review

import com.shoshin.data.entities.review.ReviewRemote
import com.shoshin.data.entities.review.ReviewRemoteToReviewMapper
import com.shoshin.data.entities.reviews_response.ReviewResponseToReviewsRemoteMapper
import com.shoshin.data.entities.reviews_response.ReviewsResponse
import com.shoshin.domain.common.Mapper
import com.shoshin.domain.entities.Review
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class ReviewModule {
    @Provides
    fun provideResponseToReviewsRemoteMapper(): Mapper<ReviewsResponse, List<ReviewRemote>>
        = ReviewResponseToReviewsRemoteMapper()

    @Provides
    fun provideReviewRemoteToReviewMapper(): Mapper<ReviewRemote, Review>
        = ReviewRemoteToReviewMapper()
}