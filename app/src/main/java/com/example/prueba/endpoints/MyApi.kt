package com.example.prueba.endpoints

import com.example.prueba.dtos.Images
import retrofit2.http.GET
import retrofit2.Call


interface MyApi {
    @GET("/v1/images/search?limit=10&has_breeds=1")
    fun getPosts() : Call<List<Images>>
}