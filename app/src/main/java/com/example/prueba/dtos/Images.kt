package com.example.prueba.dtos

import com.squareup.moshi.JsonClass

//serealizar/deserealizar la info
@JsonClass(generateAdapter = true)

data class Images(
    val id: String,
    val url: String,
)
