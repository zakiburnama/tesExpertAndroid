package com.example.faktaanime.core.domain.usecase

import com.example.faktaanime.core.data.Resource
import com.example.faktaanime.core.domain.model.Anime
import kotlinx.coroutines.flow.Flow

interface TourismUseCase {
    fun getAllTourism(): Flow<Resource<List<Anime>>>
    fun getFavoriteTourism(): Flow<List<Anime>>
    fun setFavoriteTourism(anime: Anime, state: Boolean)
}