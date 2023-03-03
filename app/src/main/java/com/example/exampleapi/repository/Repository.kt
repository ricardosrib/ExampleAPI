package com.example.exampleapi.repository

import com.example.exampleapi.api.RetrofitInstance
import com.example.exampleapi.model.Posts

class Repository {

    // repository class
    suspend fun getPosts(): Posts {
        return RetrofitInstance.api.getPosts()
    }
}