package com.example.prueba.endpoints

import com.example.prueba.dtos.Images
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Headers


interface MyApi {
    @Headers("X-Api-Key: 2LnOIc0Jt8X7yCOPbDxf7A==igr0Bn10OenMZGBe")
    @GET("/v1/cats?grooming=5")
    fun getPosts() : Call<List<Images>>
}