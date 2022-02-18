package com.shoshin.data.entities.review

import com.google.gson.annotations.SerializedName
import com.shoshin.data.entities.link.LinkRemote
import com.shoshin.data.entities.multimedia.MultimediaRemote

data class ReviewRemote(
    @field:SerializedName("multimedia")
    val multimedia: MultimediaRemote? = null,
    @field:SerializedName("date_updated")
    val dateUpdated: String? = null,
    @field:SerializedName("display_title")
    val displayTitle: String? = null,
    @field:SerializedName("link")
    val link: LinkRemote? = null,
    @field:SerializedName("publication_date")
    val publicationDate: String? = null,
    @field:SerializedName("summary_short")
    val summaryShort: String? = null,
    @field:SerializedName("critics_pick")
    val criticsPick: Int? = null,
    @field:SerializedName("byline")
    val byline: String? = null,
    @field:SerializedName("headline")
    val headline: String? = null,
    @field:SerializedName("mpaa_rating")
    val mpaaRating: String? = null,
    @field:SerializedName("opening_date")
    val openingDate: Any? = null
)