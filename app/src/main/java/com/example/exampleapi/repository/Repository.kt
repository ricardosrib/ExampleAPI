package com.example.exampleapi.repository

import com.example.exampleapi.api.RetrofitInstance
import com.example.exampleapi.model.Posts
import retrofit2.Response

class Repository {

    // repository class

    suspend fun getPosts(): Response<Posts> {
        return RetrofitInstance.api.getPosts()
    }

    suspend fun getPostsDynamic(number: Int): Response<Posts> {
        return RetrofitInstance.api.getPostsDynamic(number)
    }

    // post field repository
    suspend fun pushPosts(userId: Int, id: Int, title: String, body: String): Response<Posts> {
        return RetrofitInstance.api.pushPost(userId, id, title, body)
    }
}