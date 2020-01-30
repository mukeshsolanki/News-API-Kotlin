package org.newsapi.model.response

import org.newsapi.model.Source

data class SourcesResponse(
    val status: String,
    val sources: List<Source>
)