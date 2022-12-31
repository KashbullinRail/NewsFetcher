package com.example.newsfetcher.feature.main_screen.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.newsfetcher.R
import com.example.newsfetcher.databinding.ItemArticleAdapterBinding
import com.example.newsfetcher.feature.main_screen.domian.ArticleModel


const val BOOKMARK_EMPTY = "BOOKMARK_EMPTY"
const val BOOKMARK_FULL = "BOOKMARK_FULL"
const val ARTICLE_ITEM = "ARTICLE_ITEM"

class MainArticleAdapter(
    val onItemClicked: (Int, String) -> Unit
) : RecyclerView.Adapter<MainArticleAdapter.MainArticleViewHolder>() {

    class MainArticleViewHolder(
        val binding: ItemArticleAdapterBinding
    ) : RecyclerView.ViewHolder(binding.root)

    var articles: List<ArticleModel> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = articles.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainArticleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemArticleAdapterBinding.inflate(inflater, parent, false)
        return MainArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainArticleViewHolder, position: Int) {

        //handle pressing the open detail item
        holder.itemView.setOnClickListener {
            onItemClicked.invoke(position, ARTICLE_ITEM)
        }

        val article = articles[position]
        with(holder.binding) {

            //handle pressing the delete item
            ivBookmarksEmpty.setOnClickListener {
                articles[position].selectedBookmark = !articles[position].selectedBookmark
                holder.binding.ivBookmarksEmpty.isVisible = !articles[position].selectedBookmark
                holder.binding.ivBookmarksFull.isVisible = articles[position].selectedBookmark
                onItemClicked.invoke(position, BOOKMARK_EMPTY)
            }

            //handle pressing the add bookmark item
            ivBookmarksFull.setOnClickListener {
                articles[position].selectedBookmark = !articles[position].selectedBookmark
                holder.binding.ivBookmarksEmpty.isVisible = !articles[position].selectedBookmark
                holder.binding.ivBookmarksFull.isVisible = articles[position].selectedBookmark
                onItemClicked.invoke(position, BOOKMARK_FULL)
            }

            //update variables
            holder.itemView.tag = article
            tvNameMain.text = article.name
            tvTitleMain.text = article.title
            tvDataMain.text = article.publishedAt
            holder.binding.ivBookmarksEmpty.isVisible = !articles[position].selectedBookmark
            holder.binding.ivBookmarksFull.isVisible = articles[position].selectedBookmark

            Glide
                .with(ivNewsImageMain.context)
                .load(article.urlToImage)
                .placeholder(R.drawable.ic_image)
                .error(R.drawable.ic_image_not_supported)
                .transition(DrawableTransitionOptions.withCrossFade())
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .centerCrop()
                .into(ivNewsImageMain)

        }

    }

    //redrawing UI
    @SuppressLint("NotifyDataSetChanged")
    fun setData(articles: List<ArticleModel>) {
        this.articles = articles
        notifyDataSetChanged()
    }

}