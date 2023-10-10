package com.example.prueba.endpoints

import com.example.prueba.dtos.Images
import retrofit2.http.GET
import retrofit2.Call


interface MyApi {
    //@Headers("x-api-key", "live_xb2dA86LCk5sBRFraCWx5doAHKIcrfWAsWIe5x6zfiHyoPUhfi6NiFKLZgW95e0z")
    @GET("/v1/images/search?limit=10")
    fun getPosts(): Call<List<Images>>
}