package com.dicoding.tourismapp.core.domain.usecase

import com.dicoding.tourismapp.core.data.Resource
import com.dicoding.tourismapp.core.domain.model.Anime
import com.dicoding.tourismapp.core.domain.model.Tourism
import kotlinx.coroutines.flow.Flow

interface TourismUseCase {
    fun getAllTourism(): Flow<Resource<List<Anime>>>
    fun getFavoriteTourism(): Flow<List<Anime>>
    fun setFavoriteTourism(anime: Anime, state: Boolean)
}