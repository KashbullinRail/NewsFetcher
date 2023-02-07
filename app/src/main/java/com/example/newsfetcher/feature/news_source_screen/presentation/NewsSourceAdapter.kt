package com.example.newsfetcher.feature.news_source_screen.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationSet
import android.view.animation.ScaleAnimation
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


class NewsSourceAdapter(
        val onItemClicked: (Int, String) -> Unit
    ) : RecyclerView.Adapter<NewsSourceAdapter.NewsSourceViewHolder>() {

        class NewsSourceViewHolder(
            val binding: ItemArticleAdapterBinding
        ) : RecyclerView.ViewHolder(binding.root)

        var articles: List<ArticleModel> = emptyList()
            set(newValue) {
                field = newValue
                notifyDataSetChanged()
            }

        override fun getItemCount(): Int = articles.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsSourceViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemArticleAdapterBinding.inflate(inflater, parent, false)
            return NewsSourceViewHolder(binding)
        }

        override fun onBindViewHolder(holder: NewsSourceViewHolder, position: Int) {

            //handle pressing the open detail item
            holder.itemView.setOnClickListener {
                onItemClicked.invoke(position, ARTICLE_ITEM)
            }

            val article = articles[position]
            with(holder.binding) {

                //bookmark click animation
                val animationBookmark by lazy(LazyThreadSafetyMode.NONE) {
                    val toSmall = ScaleAnimation(1f, 0.75f, 1f, 0.75f)
                    val smallToLarge = ScaleAnimation(1f, 1.8f, 1f, 1.8f)
                    val largeToNormal = ScaleAnimation(1f, 0.75f, 1f, 0.75f)
                    val anim = AnimationSet(true).apply {
                        addAnimation(toSmall)
                        addAnimation(smallToLarge)
                        addAnimation(largeToNormal)
                    }
                    anim.animations.forEach { animation ->
                        animation.duration = 200L
                        animation.startOffset = 100L
                    }
                    anim
                }

                //handle pressing the delete item
                ivBookmarksEmpty.setOnClickListener {
                    val select = articles[position].selectedBookmark
                    articles[position].selectedBookmark = !select
                    ivBookmarksEmpty.isVisible = select
                    ivBookmarksFull.isVisible = !select
                    ivBookmarksFull.startAnimation(animationBookmark)
                    onItemClicked.invoke(position, BOOKMARK_EMPTY)
                }

                //handle pressing the add bookmark item
                ivBookmarksFull.setOnClickListener {
                    val select = articles[position].selectedBookmark
                    articles[position].selectedBookmark = !select
                    ivBookmarksEmpty.isVisible = select
                    ivBookmarksFull.isVisible = !select
                    onItemClicked.invoke(position, BOOKMARK_FULL)
                }

                //setting variables
                holder.itemView.tag = article
                tvNameMain.text = article.name
                tvTitleMain.text = article.title
                tvDataMain.text = article.publishedAt
                ivBookmarksEmpty.isVisible = !articles[position].selectedBookmark
                ivBookmarksFull.isVisible = articles[position].selectedBookmark
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