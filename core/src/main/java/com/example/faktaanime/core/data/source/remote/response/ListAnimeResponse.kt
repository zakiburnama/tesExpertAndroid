package com.example.faktaanime.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListAnimeResponse(

    @field:SerializedName("success")
    val success: Boolean,

    @field:SerializedName("data")
    val data: List<AnimeResponse>
)