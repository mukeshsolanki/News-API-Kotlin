package `in`.madapps.newsapidemo.adapter

import `in`.madapps.newsapidemo.R
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import org.newsapi.model.Source

class SourcesAdapter(private val sources: List<Source>, private val context: Context) :
    RecyclerView.Adapter<SourcesAdapter.SourcesViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): SourcesViewHolder {
        return SourcesViewHolder(
            LayoutInflater.from(viewGroup.context).inflate(
                R.layout.sources_item_view, viewGroup, false
            )
        )
    }

    override fun onBindViewHolder(holder: SourcesViewHolder, position: Int) {
        val source = sources[position]
        holder.nameTextView.text =
            String.format(context.getString(R.string.name), source.name)
        holder.descriptionTextView.text =
            String.format(context.getString(R.string.description), source.description)
        holder.categoryTextView.text =
            String.format(context.getString(R.string.category), source.category)
        holder.languageTextView.text =
            String.format(context.getString(R.string.language), source.language)
        holder.countryTextView.text =
            String.format(context.getString(R.string.country), source.country)
        holder.itemView.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(source.url))
            startActivity(context, browserIntent, null)
        }
    }

    override fun getItemCount(): Int {
        return sources.size
    }

    class SourcesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        var descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
        var categoryTextView: TextView = itemView.findViewById(R.id.categoryTextView)
        var languageTextView: TextView = itemView.findViewById(R.id.languageTextView)
        var countryTextView: TextView = itemView.findViewById(R.id.countryTextView)
    }
}