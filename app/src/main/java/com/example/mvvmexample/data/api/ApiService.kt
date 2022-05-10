package com.example.mvvmexample.data.api

import com.example.mvvmexample.model.Post
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getPosts() : List<Post>


}