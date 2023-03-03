package com.example.exampleapi.api

import com.example.exampleapi.model.Posts
import retrofit2.http.GET

interface API {

    // get posts api interface
    @GET("posts/1")
    suspend fun getPosts(): Posts
}