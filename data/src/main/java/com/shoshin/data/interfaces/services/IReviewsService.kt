package com.shoshin.data.interfaces.services

import com.shoshin.data.entities.reviews_response.ReviewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface IReviewsService {
    @GET("svc/movies/v2/reviews/all.json")
    suspend fun getReviews(
        @Query("api-key") apiKey: String,
        @Query("offset") offset: Int
    ): ReviewsResponse
}