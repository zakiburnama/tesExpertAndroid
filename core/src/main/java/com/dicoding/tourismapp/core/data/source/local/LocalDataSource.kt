package com.dicoding.tourismapp.core.data.source.local

import com.dicoding.tourismapp.core.data.source.local.entity.AnimeEntity
import com.dicoding.tourismapp.core.data.source.local.room.TourismDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val tourismDao: TourismDao) {

    fun getAllTourism(): Flow<List<AnimeEntity>> = tourismDao.getAllTourism()

    fun getFavoriteTourism(): Flow<List<AnimeEntity>> = tourismDao.getFavoriteTourism()

    suspend fun insertTourism(animeList: List<AnimeEntity>) = tourismDao.insertTourism(animeList)

    fun setFavoriteTourism(anime: AnimeEntity, newState: Boolean) {
        anime.isFavorite = newState
        tourismDao.updateFavoriteTourism(anime)
    }
}