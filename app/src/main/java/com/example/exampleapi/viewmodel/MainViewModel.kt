package com.example.exampleapi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exampleapi.model.Posts
import com.example.exampleapi.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<Response<Posts>> = MutableLiveData()
    val myPushResponse: MutableLiveData<Response<Posts>> = MutableLiveData()

    // call the API and then put the response within the MutableLiveData object
    // later the MutableLiveData object will be observed from the MainActivity

    fun getPosts() {
        viewModelScope.launch {
            val response = repository.getPosts()
            myResponse.value = response
        }
    }

    fun pushPosts(userId: Int, id: Int, title: String, body: String) {
        viewModelScope.launch {
            val response = repository.pushPosts(userId, id, title, body)
            myPushResponse.value = response
        }
    }
}