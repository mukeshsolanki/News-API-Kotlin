package org.newsapi.model

data class ApiError(
    val status: String,
    val code: String,
    val message: String
)