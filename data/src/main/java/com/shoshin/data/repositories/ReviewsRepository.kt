package com.shoshin.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.shoshin.data.interfaces.sources.IReviewRemoteSource
import com.shoshin.data.sources.ReviewPagingSource
import com.shoshin.domain.entities.Review
import com.shoshin.domain.repositories.IReviewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReviewsRepository @Inject constructor(
    private val reviewRemoteSource: IReviewRemoteSource,
): IReviewsRepository {
    override fun getReviews(): Flow<PagingData<Review>> {
        return Pager(
            config = PagingConfig(
                pageSize = ReviewPagingSource.PAGE_SIZE,
                enablePlaceholders = false,
                maxSize = 1000
            ),
            pagingSourceFactory = { ReviewPagingSource(reviewRemoteSource) }
        ).flow
    }
}