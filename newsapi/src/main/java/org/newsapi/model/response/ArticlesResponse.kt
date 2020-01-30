package org.newsapi.model.response

import org.newsapi.model.Article

data class ArticlesResponse(
    val status: String,
    val totalResults: String,
    val articles: List<Article>
)