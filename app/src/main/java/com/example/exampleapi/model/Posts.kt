package com.example.exampleapi.model

import com.google.gson.annotations.SerializedName

data class Posts (

    // @SerializedName("api_field")

    @SerializedName("userId")
    val userId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String
    )