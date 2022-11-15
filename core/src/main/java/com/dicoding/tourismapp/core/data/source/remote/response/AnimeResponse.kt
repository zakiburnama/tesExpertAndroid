package com.dicoding.tourismapp.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

//class AnimeResponse {
//}

data class AnimeResponse(
    @field:SerializedName("anime_id")
    val anime_id: Int,

    @field:SerializedName("anime_name")
    val anime_name: String,

    @field:SerializedName("anime_img")
    val anime_img: String
)