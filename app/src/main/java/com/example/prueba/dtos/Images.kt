package com.example.prueba.dtos

import com.squareup.moshi.JsonClass

//serealizar/deserealizar la info
@JsonClass(generateAdapter = true)

data class Images(
    val name: String,
    val image_link: String,
    val family_friendly: Int,
    val grooming: Int,
    val shedding: Int,
    val other_pets_friendly: Int
)
