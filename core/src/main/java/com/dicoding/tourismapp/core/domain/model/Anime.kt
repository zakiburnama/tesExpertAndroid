package com.dicoding.tourismapp.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Anime(
    val id: Int,
    val name: String,
    val img: String,
    val isFavorite: Boolean
) : Parcelable