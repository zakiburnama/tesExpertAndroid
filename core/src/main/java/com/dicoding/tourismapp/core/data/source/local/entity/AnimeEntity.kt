package com.dicoding.tourismapp.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//class AnimeEntity {
//}

@Entity(tableName = "anime")
data class AnimeEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "img")
    var img: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)