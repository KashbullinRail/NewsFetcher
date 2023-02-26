package com.example.newsfetcher.feature.source_bookmarks_screen.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.newsfetcher.databinding.ItemSourceBookmarkAdapterBinding
import com.example.newsfetcher.feature.news_source_screen.domain.SourceModel


const val SOURCE_BOOKMARK_DELETE = "SOURCE_BOOKMARK_DELETE"
const val SOURCE_BOOKMARK_ITEM = "SOURCE_BOOKMARK_ITEM"


class SourceBookmarksDiffCallback(
    private val oldList: List<SourceModel>,
    private val newList: List<SourceModel>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldBookmark = oldList[oldItemPosition]
        val newBookmark = newList[newItemPosition]
        return oldBookmark.id == newBookmark.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldBookmark = oldList[oldItemPosition]
        val newBookmark = newList[newItemPosition]
        return oldBookmark.id == newBookmark.id &&
                oldBookmark.description == newBookmark.description
    }

}

class SourceBookmarksAdapter(
    val onItemClicked: (Int, String) -> Unit
) : RecyclerView.Adapter<SourceBookmarksAdapter.SourceBookmarksViewHolder>() {

    class SourceBookmarksViewHolder(
        val binding: ItemSourceBookmarkAdapterBinding
    ) : RecyclerView.ViewHolder(binding.root)

    var sourceBookmarks: List<SourceModel> = emptyList()
        set(newValue) {
            val diffCallback = SourceBookmarksDiffCallback(field, newValue)
            val diffResult = DiffUtil.calculateDiff(diffCallback)
            field = newValue
            diffResult.dispatchUpdatesTo(this)
        }

    override fun getItemCount(): Int = sourceBookmarks.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SourceBookmarksViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSourceBookmarkAdapterBinding.inflate(inflater, parent, false)
        return SourceBookmarksViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SourceBookmarksViewHolder, position: Int) {

        //handle pressing the open detail item
        holder.itemView.setOnClickListener {
            onItemClicked.invoke(position, SOURCE_BOOKMARK_ITEM)
        }

        val source = sourceBookmarks[position]
        with(holder.binding) {

            //handle pressing the delete item
            ivSourceBookmarksDelete.setOnClickListener {
                onItemClicked.invoke(position, SOURCE_BOOKMARK_DELETE)
                notifyItemRemoved(position)
            }

            //update variables
            holder.itemView.tag = source
            tvNameSourceBookmark.text = source.name
            tvTitleSourceBookmark.text = source.description

        }

    }

    //redrawing UI
    @SuppressLint("NotifyDataSetChanged")
    fun setData(sources: List<SourceModel>) {
        this.sourceBookmarks = sources
        notifyDataSetChanged()
    }

}