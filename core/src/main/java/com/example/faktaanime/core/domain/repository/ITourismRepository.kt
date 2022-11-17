package com.example.faktaanime.core.domain.repository

import com.example.faktaanime.core.data.Resource
import com.example.faktaanime.core.domain.model.Anime
import kotlinx.coroutines.flow.Flow

interface ITourismRepository {

    fun getAllTourism(): Flow<Resource<List<Anime>>>

    fun getFavoriteTourism(): Flow<List<Anime>>

    fun setFavoriteTourism(anime: Anime, state: Boolean)

}