package com.example.mvvmexample.repository

import com.example.mvvmexample.data.api.ApiService

class PostRepository(private val apiService: ApiService) {
    suspend fun getPosts() = apiService.getPosts()
}