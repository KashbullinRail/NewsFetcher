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
import com.example.newsfetcher.databinding.ItemNewsSourceAdapterBinding
import com.example.newsfetcher.feature.news_source_screen.domain.SourceModel


const val STAR_EMPTY = "STAR_EMPTY"
const val STAR_FULL = "STAR_FULL"
const val SOURCE_ITEM = "SOURCE_ITEM"


class NewsSourceAdapter(
        val onItemClicked: (Int, String) -> Unit
    ) : RecyclerView.Adapter<NewsSourceAdapter.NewsSourceViewHolder>() {

        class NewsSourceViewHolder(
            val binding: ItemNewsSourceAdapterBinding
        ) : RecyclerView.ViewHolder(binding.root)

        var sources: List<SourceModel> = emptyList()
            set(newValue) {
                field = newValue
                notifyDataSetChanged()
            }

        override fun getItemCount(): Int = sources.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsSourceViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemNewsSourceAdapterBinding.inflate(inflater, parent, false)
            return NewsSourceViewHolder(binding)
        }

        override fun onBindViewHolder(holder: NewsSourceViewHolder, position: Int) {

            //handle pressing the open detail item
            holder.itemView.setOnClickListener {
                onItemClicked.invoke(position, SOURCE_ITEM)
            }

            val source = sources[position]
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
                ivStarEmpty.setOnClickListener {
                    val select = sources[position].selectSource
                    sources[position].selectSource = !select
                    ivStarEmpty.isVisible = select
                    ivStarFull.isVisible = !select
                    ivStarFull.startAnimation(animationBookmark)
                    onItemClicked.invoke(position, STAR_EMPTY)
                }
                //handle pressing the add bookmark item
                ivStarFull.setOnClickListener {
                    val select = sources[position].selectSource
                    sources[position].selectSource = !select
                    ivStarEmpty.isVisible = select
                    ivStarFull.isVisible = !select
                    onItemClicked.invoke(position, STAR_FULL)
                }
                //setting variables
                holder.itemView.tag = source
                tvNameSource.text = source.name
                tvDescriptionSource.text = source.description
                ivStarEmpty.isVisible = !sources[position].selectSource
                ivStarFull.isVisible = sources[position].selectSource

            }

        }

        //redrawing UI
        @SuppressLint("NotifyDataSetChanged")
        fun setData(sources: List<SourceModel>) {
            this.sources = sources
            notifyDataSetChanged()
        }

}