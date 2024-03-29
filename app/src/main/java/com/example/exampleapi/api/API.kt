package com.example.exampleapi.api

import com.example.exampleapi.model.Posts
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface API {

    // get posts api interface (path hardcoded)
    @GET("posts/1")
    suspend fun getPosts(): Response<Posts>

    // get posts api interface (path dynamic)
    @GET("posts/{postNumber}")
    suspend fun getPostsDynamic(
        @Path("postNumber") number: Int
    ): Response<Posts>

    // get posts api interface (query for some field value in the api)
    @GET("posts")
    suspend fun getPostsCustom(
        @Query("userId") userId: Int
    ): Response<List<Posts>>

    @GET("posts")
    suspend fun getCustomPostsMultipleQueries(
        @Query("userId") userId: Int,
        @QueryMap options: Map<String, String>
    ): Response<List<Posts>>

    // post (JSON)
    @POST("posts")
    suspend fun pushPost1(
        @Body post: Posts
    ): Response<Posts>

    // post (Url Encoded)
    @FormUrlEncoded
    @POST("posts")
    suspend fun pushPost(
        @Field("userId") userId: Int,
        @Field("id") id: Int,
        @Field("title") title: String,
        @Field("body") body: String
    ): Response<Posts>
}

/*

JSON vs @FormUrlEncoded

JSON - the content you want to push to the server will be sent as a JSON object in the body of the request

@FormUrlEncoded - the content will be sent via url, with each parameter separated by &

*/