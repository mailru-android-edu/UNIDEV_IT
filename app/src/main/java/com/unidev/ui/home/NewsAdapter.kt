package com.unidev.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.unidev.R

class NewsAdapter(private val news: List<NewsItem>) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val newsItem = news[position]
        holder.bind(newsItem)
    }

    override fun getItemCount(): Int = news.size

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val ivBackground: ImageView = itemView.findViewById(R.id.item_news__iv_background)
        private val tvTitle: TextView = itemView.findViewById(R.id.item_news__tv_title)
        private val tvDate: TextView = itemView.findViewById(R.id.item_news__tv_date)

        fun bind(newsItem: NewsItem) {
            tvTitle.text = newsItem.title
            tvDate.text = newsItem.date
            ivBackground.setBackgroundResource(newsItem.image)
        }
    }
}
