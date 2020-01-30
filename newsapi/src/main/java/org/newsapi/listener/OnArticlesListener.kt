package org.newsapi.listener

import org.newsapi.model.ApiError
import org.newsapi.model.response.ArticlesResponse

interface OnArticlesListener {
    fun onArticlesResponse(articlesResponse: ArticlesResponse)
    fun onError(apiError: ApiError?)
}