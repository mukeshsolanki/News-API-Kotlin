package org.newsapi.listener

import org.newsapi.model.ApiError
import org.newsapi.model.response.SourcesResponse

interface OnSourcesListener {
    fun onSourcesResponse(sourcesResponse: SourcesResponse)
    fun onError(apiError: ApiError?)
}