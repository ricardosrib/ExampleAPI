package com.example.exampleapi.repository

import com.example.exampleapi.api.RetrofitInstance
import com.example.exampleapi.model.Posts
import retrofit2.Response
import retrofit2.http.POST

class Repository {

    // repository class

    suspend fun getPosts(): Response<Posts> {
        return RetrofitInstance.api.getPosts()
    }

    suspend fun getPostsDynamic(number: Int): Response<Posts> {
        return RetrofitInstance.api.getPostsDynamic(number)
    }

    suspend fun getPostsCustom(userId: Int): Response<List<Posts>> {
        return RetrofitInstance.api.getPostsCustom(userId)
    }

    suspend fun getCustomPostsMultipleQueries(userId: Int, options: Map<String, String>): Response<List<Posts>> {
        return RetrofitInstance.api.getCustomPostsMultipleQueries(userId, options)
    }

    // post JSON
    suspend fun pushPosts1(post: Posts): Response<Posts> {
        return RetrofitInstance.api.pushPost1(post)
    }

    // post UrlEncoded
    suspend fun pushPosts(userId: Int, id: Int, title: String, body: String): Response<Posts> {
        return RetrofitInstance.api.pushPost(userId, id, title, body)
    }
}