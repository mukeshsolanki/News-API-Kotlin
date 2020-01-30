package `in`.madapps.newsapidemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.newsapi.NewsApi
import org.newsapi.listener.OnSourcesListener
import org.newsapi.model.ApiError
import org.newsapi.model.response.SourcesResponse


class MainActivity : AppCompatActivity() {

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        NewsApi.getSources(onSourcesListener = object :
            OnSourcesListener {
            override fun onSourcesResponse(sourcesResponse: SourcesResponse) {
                Log.d("Response=>", sourcesResponse.toString())
            }

            override fun onError(apiError: ApiError?) {
                Log.e("Response=>", apiError.toString())
            }
        })
    }
}
