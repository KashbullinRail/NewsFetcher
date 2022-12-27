package com.example.newsfetcher.feature.main_screen.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.newsfetcher.R
import com.example.newsfetcher.feature.main_screen.domian.ArticleModel


class ArticlesAdapter(val onItemClicked: (Int) -> Unit) :
    RecyclerView.Adapter<ArticlesAdapter.ViewHolder>() {

    private var articlesData: List<ArticleModel> = emptyList()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitleMain: TextView = view.findViewById(R.id.tvTitleMain)
        val tvDataMain: TextView = view.findViewById(R.id.tvDataMain)
        val ivNewsImageMain: ImageView = view.findViewById(R.id.ivNewsImageMain)
        val tvNameMain: TextView = view.findViewById(R.id.tvNameMain)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_article_adapter, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.itemView.setOnClickListener {
            onItemClicked.invoke(position)
        }

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.tvTitleMain.text = articlesData[position].title
        viewHolder.tvDataMain.text = articlesData[position].publishedAt
        viewHolder.tvNameMain.text = articlesData[position].name

        Glide
            .with(viewHolder.itemView.context)
            .load(articlesData[position].urlToImage)
            .placeholder(R.drawable.ic_image)
            .error(R.drawable.ic_image_not_supported)
            .transition(DrawableTransitionOptions.withCrossFade())
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .centerCrop()
            .into(viewHolder.ivNewsImageMain)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = articlesData.size

    fun setData(articles: List<ArticleModel>) {
        articlesData = articles
        notifyDataSetChanged()
    }

}