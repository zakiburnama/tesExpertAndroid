package com.dicoding.tourismapp.core.data.source.local.room

import androidx.room.*
import com.dicoding.tourismapp.core.data.source.local.entity.AnimeEntity
import com.dicoding.tourismapp.core.data.source.local.entity.TourismEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TourismDao {

    @Query("SELECT * FROM anime")
    fun getAllTourism(): Flow<List<AnimeEntity>>

    @Query("SELECT * FROM anime where isFavorite = 1")
    fun getFavoriteTourism(): Flow<List<AnimeEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTourism(tourism: List<AnimeEntity>)

    @Update
    fun updateFavoriteTourism(anime: AnimeEntity)
}
