package com.danielg07.newsapp.news

import android.util.Log
import androidx.lifecycle.*
import com.danielg07.newsapp.model.Article
import com.danielg07.newsapp.network.NewsApi
import kotlinx.coroutines.launch
import java.lang.Exception

class NewsViewModel(private val position: Int): ViewModel() {
    private val _articles = MutableLiveData<List<Article>>()

    val articles: LiveData<List<Article>> = _articles

    init {
        getNews()
    }

    private fun getNews() {
        viewModelScope.launch {
            try {
                when (position) {
                    0 -> _articles.value = NewsApi.retrofitService.getNews("it").articles
                    1 -> _articles.value = NewsApi.retrofitService.getNews("medio ambiente").articles
                    else -> _articles.value = NewsApi.retrofitService.getNews("android").articles
                }
                Log.i("News","Success: Items properties retrieved")
            } catch (e: Exception) {
                Log.e("News", "Failure: ${e.message}")
            }

        }
    }
}



