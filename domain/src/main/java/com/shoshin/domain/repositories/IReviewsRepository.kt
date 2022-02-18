package com.shoshin.domain.repositories

import androidx.paging.PagingData
import com.shoshin.domain.entities.Review
import kotlinx.coroutines.flow.Flow

interface IReviewsRepository {
    fun getReviews(): Flow<PagingData<Review>>
}