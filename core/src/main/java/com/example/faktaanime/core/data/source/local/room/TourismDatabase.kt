package com.example.faktaanime.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.faktaanime.core.data.source.local.entity.AnimeEntity

//@Database(entities = [TourismEntity::class], version = 1, exportSchema = false)
@Database(entities = [AnimeEntity::class], version = 1, exportSchema = false)
abstract class TourismDatabase : RoomDatabase() {

    abstract fun tourismDao(): TourismDao

}