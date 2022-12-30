package com.example.newsfetcher.feature.main_screen.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.newsfetcher.R
import com.example.newsfetcher.databinding.ItemArticleAdapterBinding
import com.example.newsfetcher.feature.main_screen.domian.ArticleModel

interface UserActionListener {
    fun onUserMove(user: ArticleModel, moveBy: Int)
    fun onUserDelete(user: ArticleModel)
    fun onUserDetails(user: ArticleModel)
}

class UsersAdapter(
    private val actionListener: UserActionListener
) : RecyclerView.Adapter<UsersAdapter.UsersViewHolder>(), View.OnClickListener {

    class UsersViewHolder(
        val binding: ItemArticleAdapterBinding
    ) : RecyclerView.ViewHolder(binding.root)


    var users: List<ArticleModel> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onClick(v: View) {
        val user = v.tag as ArticleModel
        when (v.id) {
            R.id.ivBookmarksBorder -> {
                Log.d("TAGG", "ivMore")
            }
            else -> {
                Log.d("TAGG", "else")
//                actionListener.onUserDetails(user)
            }
        }
    }

    override fun getItemCount(): Int = users.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemArticleAdapterBinding.inflate(inflater, parent, false)
//        return UsersViewHolder(binding)

        binding.root.setOnClickListener(this)
        binding.ivBookmarksBorder.setOnClickListener(this)
        return UsersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {

        val user = users[position]
        with(holder.binding) {
            holder.itemView.tag = user
            ivBookmarksBorder.tag = user
            tvNameMain.text = user.name
            tvTitleMain.text = user.title
            tvDataMain.text = user.publishedAt

            Glide
                .with(ivNewsImageMain.context)
                .load(user.urlToImage)
                .placeholder(R.drawable.ic_image)
                .error(R.drawable.ic_image_not_supported)
                .transition(DrawableTransitionOptions.withCrossFade())
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .centerCrop()
                .into(ivNewsImageMain)

        }
    }

//    fun setData(articles: List<ArticleModel>) {
//        users = articles
//        notifyDataSetChanged()
//    }


}