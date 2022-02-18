package com.shoshin.data.interfaces.sources

import com.shoshin.domain.entities.Review

interface IReviewRemoteSource {
    suspend fun getReviews(offset: Int): List<Review>
}