package com.danielg07.newsapp.network

import com.danielg07.newsapp.model.NewsProperties
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://newsapi.org/v2/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface NewsAPIService {
    @GET("everything?language=es&pageSize=5&page=1&apiKey=4cdd5ed136fa4e10b271eb6f3a50d512")
    suspend fun getNews(@Query("q") topic: String):NewsProperties
}

object NewsApi {
    val retrofitService: NewsAPIService by lazy { retrofit.create(NewsAPIService::class.java) }
}