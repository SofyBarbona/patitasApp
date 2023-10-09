package com.example.prueba.dtos

import com.squareup.moshi.JsonClass

//serealizar/deserealizar la info
@JsonClass(generateAdapter = true)

data class Post(
    var id:Int?,
    var tittle:String,
    var body:String,
    var userId:Int
)
