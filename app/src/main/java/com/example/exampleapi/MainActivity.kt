package com.example.exampleapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.exampleapi.databinding.ActivityMainBinding
import com.example.exampleapi.repository.Repository
import com.example.exampleapi.viewmodel.MainViewModel
import com.example.exampleapi.viewmodelfactory.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val result = binding.result

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)

        viewModel = ViewModelProvider(this@MainActivity, viewModelFactory)[MainViewModel::class.java]


        // GET

        viewModel.getPosts()

        viewModel.myResponse.observe(this@MainActivity, Observer {
            response ->

            if (response.isSuccessful) {

//                result.text = response.body()?.userId.toString()
//                result.text = response.body()?.id.toString()
                result.text = response.body()?.title!!
//                result.text = response.body()?.body!!
            } else {
                Log.d("Response", response.errorBody().toString())
                result.text = response.code().toString()
            }

        })


        // POST

//        viewModel.pushPosts(1, 1, "Ricardo API code", "Android developer")

//        viewModel.myPushResponse.observe(this@MainActivity, Observer {
//            response ->
//
////            result.text = response.toString()
//
//            result.text = "Body: " + response.body()
//
////            result.text = response.body()?.title.toString()
//
////            result.text = "Message: " + response.message()
//
////            result.text = "Code (if created = 201): " + response.code()
//        })


    }
}


/*

Order of development:

1 - model
2 - API endpoint interface
3 - utils (constants)
4 - retrofit instance object
5 - repository
6 - viewmodel
7 - viewmodel factory
8 - main activity build

*/