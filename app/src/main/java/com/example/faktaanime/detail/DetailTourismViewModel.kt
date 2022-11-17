package com.example.faktaanime.detail

import androidx.lifecycle.ViewModel
import com.example.faktaanime.core.domain.model.Anime
import com.example.faktaanime.core.domain.usecase.TourismUseCase

class DetailTourismViewModel(private val tourismUseCase: TourismUseCase) : ViewModel() {
//    fun setFavoriteTourism(tourism: Tourism, newStatus:Boolean) =
//        tourismUseCase.setFavoriteTourism(tourism, newStatus)

    fun setFavoriteTourism(anime: Anime, newStatus:Boolean) =
        tourismUseCase.setFavoriteTourism(anime, newStatus)
}

