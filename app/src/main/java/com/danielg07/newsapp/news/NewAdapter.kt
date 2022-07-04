package com.danielg07.newsapp.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.danielg07.newsapp.databinding.ListViewItemBinding
import com.danielg07.newsapp.model.Article

class NewAdapter() : ListAdapter<Article,
        NewViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return NewViewHolder(ListViewItemBinding.inflate(layoutInflater))
    }

    override fun onBindViewHolder(holder: NewViewHolder, position: Int) {
        val article = getItem(position)
        holder.bind(article)
    }

    companion object DiffCallback: DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.description == newItem.description
        }

    }

}