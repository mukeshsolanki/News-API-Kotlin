package org.newsapi

import android.annotation.SuppressLint
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import org.newsapi.listener.OnArticlesListener
import org.newsapi.listener.OnSourcesListener
import org.newsapi.model.ApiError
import org.newsapi.network.NewsService
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NewsApi {
    companion object Factory {
        private var retrofit: Retrofit? = null
        private var api: NewsService? = null
        private var apiKey: String? = null

        private const val BASE_URL: String = "https://newsapi.org/v2/"

        private fun buildRetrofit(): Retrofit? {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BASIC)
            val httpClient = OkHttpClient.Builder().addInterceptor { chain ->
                val original: Request = chain.request()
                val originalHttpUrl: HttpUrl = original.url
                val url = originalHttpUrl.newBuilder()
                    .addQueryParameter("apikey", apiKey)
                    .build()
                val requestBuilder: Request.Builder = original.newBuilder()
                    .url(url)
                val request: Request = requestBuilder.build()
                chain.proceed(request)
            }.addInterceptor(logging).build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient)
                .build()
        }

        private fun getError(error: Throwable?): ApiError? {
            val exception: HttpException = error as HttpException
            return Gson().fromJson(
                exception.response()?.errorBody()?.string(),
                ApiError::class.java
            )
        }

        @Synchronized
        fun initialize(apiKey: String) {
            this.apiKey = apiKey
            retrofit ?: synchronized(this) {
                retrofit = buildRetrofit()
            }
            api = retrofit?.create(NewsService::class.java)
        }

        @SuppressLint("CheckResult")
        fun getSources(
            country: String? = null,
            language: String? = null,
            onSourcesListener: OnSourcesListener
        ) {
            api?.getSources(country = country, language = language)
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribeOn(Schedulers.io())
                ?.subscribe({
                    onSourcesListener.onSourcesResponse(it)
                }, { error ->
                    error.printStackTrace()
                    onSourcesListener.onError(getError(error))
                })
        }

        @SuppressLint("CheckResult")
        fun getTopHeadlines(
            searchTerm: String? = null,
            sources: String? = null,
            category: String? = null,
            language: String? = null,
            country: String? = null,
            onArticlesListener: OnArticlesListener
        ) {
            api?.getTopHeadlines(
                searchTerm = searchTerm,
                sources = sources,
                category = category,
                language = language,
                country = country
            )
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribeOn(Schedulers.io())
                ?.subscribe({
                    onArticlesListener.onArticlesResponse(it)
                }, { error ->
                    error.printStackTrace()
                    onArticlesListener.onError(getError(error))
                })
        }

        @SuppressLint("CheckResult")
        fun getEverything(
            searchTerm: String? = null,
            sources: String? = null,
            domains: String? = null,
            from: String? = null,
            to: String? = null,
            language: String? = null,
            sortBy: String? = null,
            page: Int? = null,
            onArticlesListener: OnArticlesListener
        ) {
            api?.getEverything(
                searchTerm = searchTerm,
                sources = sources,
                domains = domains,
                from = from,
                to = to,
                language = language,
                sortBy = sortBy,
                page = page
            )
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribeOn(Schedulers.io())
                ?.subscribe({
                    onArticlesListener.onArticlesResponse(it)
                }, { error ->
                    error.printStackTrace()
                    onArticlesListener.onError(getError(error))
                })
        }
    }
}