package com.dicoding.tourismapp.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

//class ListAnimeResponse {
//}
data class ListAnimeResponse(

    @field:SerializedName("success")
    val success: Boolean,

//    @field:SerializedName("message")
//    val message: String,

    @field:SerializedName("data")
    val data: List<AnimeResponse>
)