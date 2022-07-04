package com.danielg07.newsapp

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.danielg07.newsapp.model.Article
import com.danielg07.newsapp.news.NewAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Article>?){
    val adapter = recyclerView.adapter as NewAdapter
    adapter.submitList(data)
}