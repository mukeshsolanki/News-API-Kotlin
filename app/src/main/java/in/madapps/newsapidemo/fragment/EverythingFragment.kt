package `in`.madapps.newsapidemo.fragment

import `in`.madapps.newsapidemo.R
import `in`.madapps.newsapidemo.adapter.ArticlesAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_everything.*
import org.newsapi.NewsApi
import org.newsapi.listener.OnArticlesListener
import org.newsapi.model.ApiError
import org.newsapi.model.response.ArticlesResponse

class EverythingFragment : Fragment(), OnArticlesListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_everything, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        NewsApi.getEverything(onArticlesListener = this, searchTerm = "dji")
    }

    override fun onArticlesResponse(articlesResponse: ArticlesResponse) {
        val adapter = ArticlesAdapter(articlesResponse.articles, context!!)
        everythingRecyclerView.setHasFixedSize(true)
        everythingRecyclerView.layoutManager = LinearLayoutManager(context)
        everythingRecyclerView.adapter = adapter
    }

    override fun onError(apiError: ApiError?) {
        Snackbar.make(everythingRootView, apiError?.message.toString(), Snackbar.LENGTH_SHORT)
            .show()
    }
}
