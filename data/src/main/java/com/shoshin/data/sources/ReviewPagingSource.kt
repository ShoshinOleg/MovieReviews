package com.shoshin.data.sources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.shoshin.data.interfaces.sources.IReviewRemoteSource
import com.shoshin.domain.entities.Review


class ReviewPagingSource(
    private val reviewRemoteSource: IReviewRemoteSource
): PagingSource<Int, Review>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Review> {
        val offset = params.key ?: 0

        return try {
            val reviews = reviewRemoteSource.getReviews(offset)
            LoadResult.Page(
                data = reviews,
                prevKey = if(offset == 0) null else offset - PAGE_SIZE,
                nextKey = if(reviews.size == PAGE_SIZE) offset + PAGE_SIZE else null
            )
        } catch (e: Exception) {
            LoadResult.Error(throwable = e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Review>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(PAGE_SIZE) ?: page.nextKey?.minus(PAGE_SIZE)
    }

    companion object {
        const val PAGE_SIZE = 20
    }
}