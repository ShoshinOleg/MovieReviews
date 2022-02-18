package com.shoshin.domain.usecases.interfaces

import androidx.paging.PagingData
import com.shoshin.domain.entities.Review
import kotlinx.coroutines.flow.Flow

interface IGetReviewUseCase {
    fun getReviews(): Flow<PagingData<Review>>
}