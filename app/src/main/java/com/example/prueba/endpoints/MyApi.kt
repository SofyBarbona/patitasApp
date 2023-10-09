package com.example.prueba.endpoints

import com.example.prueba.dtos.Post
import retrofit2.http.GET
import retrofit2.Call


interface MyApi {

    @GET("/post")
    fun getPost(): Call<List<Post>>
}