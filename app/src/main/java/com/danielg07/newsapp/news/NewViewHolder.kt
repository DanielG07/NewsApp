package com.danielg07.newsapp.news

import androidx.recyclerview.widget.RecyclerView
import com.danielg07.newsapp.databinding.ListViewItemBinding
import com.danielg07.newsapp.model.Article

class NewViewHolder(private var binding: ListViewItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(ItemResult: Article){
        binding.article = ItemResult
        binding.executePendingBindings()
    }
}