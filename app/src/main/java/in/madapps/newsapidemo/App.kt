package `in`.madapps.newsapidemo

import android.app.Application
import org.newsapi.NewsApi

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        NewsApi.initialize("YOUR_API_KEY")
    }
}