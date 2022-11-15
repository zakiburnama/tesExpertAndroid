package com.dicoding.tourismapp.detail

import androidx.lifecycle.ViewModel
import com.dicoding.tourismapp.core.domain.model.Anime
import com.dicoding.tourismapp.core.domain.usecase.TourismUseCase

class DetailTourismViewModel(private val tourismUseCase: TourismUseCase) : ViewModel() {
//    fun setFavoriteTourism(tourism: Tourism, newStatus:Boolean) =
//        tourismUseCase.setFavoriteTourism(tourism, newStatus)

    fun setFavoriteTourism(anime: Anime, newStatus:Boolean) =
        tourismUseCase.setFavoriteTourism(anime, newStatus)
}

