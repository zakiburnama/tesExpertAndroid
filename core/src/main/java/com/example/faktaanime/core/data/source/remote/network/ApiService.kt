package com.example.faktaanime.core.data.source.remote.network

import com.example.faktaanime.core.data.source.remote.response.ListAnimeResponse
import retrofit2.http.GET

interface ApiService {
//    @GET("list")
//    suspend fun getList(): ListTourismResponse

    @GET("v1")
    suspend fun getList(): ListAnimeResponse
}
