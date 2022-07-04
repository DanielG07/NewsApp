package com.danielg07.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.danielg07.newsapp.databinding.ActivityNewsBinding
import com.danielg07.newsapp.network.NewsApi
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}