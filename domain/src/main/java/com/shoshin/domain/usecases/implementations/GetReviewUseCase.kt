package com.shoshin.domain.usecases.implementations

import androidx.paging.PagingData
import com.shoshin.domain.entities.Review
import com.shoshin.domain.repositories.IReviewsRepository
import com.shoshin.domain.usecases.interfaces.IGetReviewUseCase

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetReviewUseCase @Inject constructor(
    private val repository: IReviewsRepository
): IGetReviewUseCase {
    override fun getReviews(): Flow<PagingData<Review>> = repository.getReviews()
}