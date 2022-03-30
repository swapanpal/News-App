package com.example.newsapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.models.Article
import kotlinx.android.synthetic.main.item_article_preview.view.*

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

    inner class ArticleViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    // create a callback method to update dataset that has changed(only that has changed)
    private val differCallback = object : DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url  // we used .url as we received article from api otherwise use .id
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return  oldItem == newItem
        }
    }
    // Create an instance of AsyncListDiffer that will be run on background
    val differ = AsyncListDiffer(this, differCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_article_preview, parent, false))
    }
    override fun getItemCount(): Int {
        return differ.currentList.size  // Due to we have no class constructor of List
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = differ.currentList[position]  //get the current list of item
        holder.itemView.apply {
            Glide.with(this).load(article.urlToImage).into(ivArticleImage)  // Used Glide to handle Image from api
            tvSource.text = article.source.name
            tvTitle.text = article.title
            tvDescription.text = article.description
            tvPublishedAt.text = article.publishedAt

            // call the setOnItemClickListener for clickable every item
            setOnItemClickListener {
                onItemClickListener?.let { it(article) }
            }
        }
    }

    // set a clickListener to the item
    private var onItemClickListener : ((Article) -> Unit)? = null

    // Create a function to handler clickListener
    fun setOnItemClickListener(listener : (Article) -> Unit){
        onItemClickListener = listener
    }



}