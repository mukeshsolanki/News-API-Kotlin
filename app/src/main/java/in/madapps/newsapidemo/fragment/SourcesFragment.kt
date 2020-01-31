package `in`.madapps.newsapidemo.fragment

import `in`.madapps.newsapidemo.R
import `in`.madapps.newsapidemo.adapter.SourcesAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_sources.*
import org.newsapi.NewsApi
import org.newsapi.listener.OnSourcesListener
import org.newsapi.model.ApiError
import org.newsapi.model.response.SourcesResponse

class SourcesFragment : Fragment(), OnSourcesListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sources, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        NewsApi.getSources(onSourcesListener = this)
    }

    override fun onSourcesResponse(sourcesResponse: SourcesResponse) {
        val adapter = SourcesAdapter(sourcesResponse.sources, context!!)
        sourcesRecyclerView.setHasFixedSize(true)
        sourcesRecyclerView.layoutManager = LinearLayoutManager(context)
        sourcesRecyclerView.adapter = adapter
    }

    override fun onError(apiError: ApiError?) {
        Snackbar.make(sourcesRootView, apiError?.message.toString(), Snackbar.LENGTH_SHORT).show()
    }
}
