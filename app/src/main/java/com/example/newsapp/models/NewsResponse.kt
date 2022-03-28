package com.example.newsapp.models

import com.example.newsapp.models.Article

/**
 * Auto generated class by json to kotlin class
 */
data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)