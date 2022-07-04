package com.danielg07.newsapp.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.danielg07.newsapp.databinding.FragmentNewsBinding


class NewsFragment(private val position: Int) : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentNewsBinding.inflate(inflater)
        binding.lifecycleOwner = this

        binding.viewModel = NewsViewModel(position)
        binding.recycler.adapter = NewAdapter()

        return binding.root
    }
}