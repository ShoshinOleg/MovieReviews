package com.shoshin.moviereviews.di.usecases


import com.shoshin.domain.usecases.implementations.GetReviewUseCase
import com.shoshin.domain.usecases.interfaces.IGetReviewUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface ReviewUseCases {
    @Binds
    fun bindGetReviewUseCase(useCase: GetReviewUseCase): IGetReviewUseCase
}