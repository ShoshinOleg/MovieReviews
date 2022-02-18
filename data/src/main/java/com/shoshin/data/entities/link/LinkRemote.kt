package com.shoshin.data.entities.link

import com.google.gson.annotations.SerializedName

data class LinkRemote(
    @field:SerializedName("suggested_link_text")
    val suggestedLinkText: String? = null,
    @field:SerializedName("type")
    val type: String? = null,
    @field:SerializedName("url")
    val url: String? = null
)