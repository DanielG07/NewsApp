package com.danielg07.newsapp.model

data class NewsProperties(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)