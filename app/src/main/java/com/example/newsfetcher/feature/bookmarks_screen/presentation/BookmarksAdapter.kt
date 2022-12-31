package com.example.newsfetcher.feature.bookmarks_screen.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.newsfetcher.R
import com.example.newsfetcher.databinding.ItemBookmarkAdapterBinding
import com.example.newsfetcher.feature.main_screen.domian.ArticleModel
import com.example.newsfetcher.feature.main_screen.presentation.BOOKMARK_DELETE
import com.example.newsfetcher.feature.main_screen.presentation.BOOKMARK_ITEM


class BookmarksAdapter(
    val onItemClicked: (Int, String) -> Unit
) : RecyclerView.Adapter<BookmarksAdapter.BookmarksViewHolder>() {

    class BookmarksViewHolder(
        val binding: ItemBookmarkAdapterBinding
    ) : RecyclerView.ViewHolder(binding.root)

    var bookmarks: List<ArticleModel> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = bookmarks.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarksViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBookmarkAdapterBinding.inflate(inflater, parent, false)
        return BookmarksViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookmarksViewHolder, position: Int) {

        //handle pressing the open detail item
        holder.itemView.setOnClickListener {
            onItemClicked.invoke(position, BOOKMARK_ITEM)
        }

        val article = bookmarks[position]
        with(holder.binding) {

            //handle pressing the delete item
            ivBookmarksDelete.setOnClickListener {
                onItemClicked.invoke(position, BOOKMARK_DELETE)
            }

            //update variables
            holder.itemView.tag = article
            tvNameBookmark.text = article.name
            tvTitleBookmark.text = article.title
            tvDataBookmark.text = article.publishedAt

            Glide
                .with(ivNewsImageBookmark.context)
                .load(article.urlToImage)
                .placeholder(R.drawable.ic_image)
                .error(R.drawable.ic_image_not_supported)
                .transition(DrawableTransitionOptions.withCrossFade())
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .centerCrop()
                .into(ivNewsImageBookmark)

        }

    }

    //redrawing UI
    @SuppressLint("NotifyDataSetChanged")
    fun setData(articles: List<ArticleModel>) {
        this.bookmarks = articles
        notifyDataSetChanged()
    }

}