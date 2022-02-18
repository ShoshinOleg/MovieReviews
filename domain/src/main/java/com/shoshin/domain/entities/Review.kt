package com.shoshin.domain.entities

data class Review (
    val title: String,
    val description: String,
    val imageUrl: String? = null,
    val articleUrl: String? = null
)