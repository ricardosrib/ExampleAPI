package com.example.exampleapi.api

import com.example.exampleapi.model.Posts
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface API {

    // get posts api interface
    @GET("posts/1")
    suspend fun getPosts(): Posts

    // post
    @FormUrlEncoded
    @POST("posts")
    suspend fun pushPost(
        @Field("userId") userId: Int,
        @Field("id") id: Int,
        @Field("title") title: String,
        @Field("body") body: String
    ): Response<Posts>
}