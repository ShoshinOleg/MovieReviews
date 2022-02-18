package com.shoshin.moviereviews.di.review

import com.shoshin.data.interfaces.sources.IReviewRemoteSource
import com.shoshin.data.repositories.ReviewsRepository
import com.shoshin.data.sources.ReviewRemoteSource
import com.shoshin.domain.repositories.IReviewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface ReviewBindModule {
    @Binds
    fun bindReviewsRepository(repository: ReviewsRepository): IReviewsRepository
    @Binds
    fun bindReviewRemoteSource(source: ReviewRemoteSource): IReviewRemoteSource
}