package org.newsapi.network

import io.reactivex.Observable
import org.newsapi.model.response.ArticlesResponse
import org.newsapi.model.response.SourcesResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface NewsService {
    @GET("sources")
    fun getSources(
        @Query("country") country: String? = null,
        @Query("language") language: String? = null
    ): Observable<SourcesResponse>

    @GET("top-headlines")
    fun getTopHeadlines(
        @Query("q") searchTerm: String? = null,
        @Query("sources") sources: String? = null,
        @Query("category") category: String? = null,
        @Query("language") language: String? = null,
        @Query("country") country: String? = null
    ): Observable<ArticlesResponse>

    @GET("everything")
    fun getEverything(
        @Query("q") searchTerm: String? = null,
        @Query("sources") sources: String? = null,
        @Query("domains") domains: String? = null,
        @Query("from") from: String? = null,
        @Query("to") to: String? = null,
        @Query("language") language: String? = null,
        @Query("sortBy") sortBy: String? = null,
        @Query("page") page: Int? = null
    ): Observable<ArticlesResponse>

}