package com.danielg07.newsapp.news

import android.util.Log
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.danielg07.newsapp.databinding.ListViewItemBinding
import com.danielg07.newsapp.model.Article
import com.danielg07.newsapp.tablayout.MainFragmentDirections

class NewViewHolder(private var binding: ListViewItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(ItemResult: Article){
        binding.article = ItemResult
        binding.btnMore.setOnClickListener{
            Log.d("Boton", "Quiero ver mas ${ItemResult.title}")

            val action = MainFragmentDirections.actionMainFragment2ToDetailFragment(ItemResult)
            Navigation.findNavController(binding.root).navigate(action)
        }
        binding.executePendingBindings()
    }
}