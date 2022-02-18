package com.shoshin.data.entities.reviews_response

import com.google.gson.annotations.SerializedName
import com.shoshin.data.entities.review.ReviewRemote

data class ReviewsResponse(
	@field:SerializedName("copyright")
	val copyright: String? = null,
	@field:SerializedName("has_more")
	val hasMore: Boolean? = null,
	@field:SerializedName("results")
	val results: List<ReviewRemote>? = null,
	@field:SerializedName("num_results")
	val numResults: Int? = null,
	@field:SerializedName("status")
	val status: String? = null
)






