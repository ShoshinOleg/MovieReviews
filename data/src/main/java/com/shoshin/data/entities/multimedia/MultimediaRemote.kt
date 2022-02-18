package com.shoshin.data.entities.multimedia

import com.google.gson.annotations.SerializedName

data class MultimediaRemote(
    @field:SerializedName("src")
    val src: String? = null,
    @field:SerializedName("width")
    val width: Int? = null,
    @field:SerializedName("type")
    val type: String? = null,
    @field:SerializedName("height")
    val height: Int? = null
)