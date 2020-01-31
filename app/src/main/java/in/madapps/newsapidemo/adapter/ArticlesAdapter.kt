package `in`.madapps.newsapidemo.adapter

import `in`.madapps.newsapidemo.R
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.newsapi.model.Article

class ArticlesAdapter(private val articles: List<Article>, private val context: Context) :
    RecyclerView.Adapter<ArticlesAdapter.ArticleViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ArticleViewHolder {
        return ArticleViewHolder(
            LayoutInflater.from(viewGroup.context).inflate(
                R.layout.articles_item_view, viewGroup, false
            )
        )
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articles[position]
        Picasso.get().load(article.urlToImage).into(holder.articleImageView)
        holder.titleTextView.text = article.title
        holder.descriptionTextView.text = article.description
        holder.publishedAtTextView.text =
            String.format(context.getString(R.string.publishedAt), article.publishedAt)
        holder.itemView.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(article.url))
            ContextCompat.startActivity(context, browserIntent, null)
        }
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var articleImageView: ImageView = itemView.findViewById(R.id.articleImageView)
        var titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        var descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
        var publishedAtTextView: TextView = itemView.findViewById(R.id.publishedAtTextView)
    }
}