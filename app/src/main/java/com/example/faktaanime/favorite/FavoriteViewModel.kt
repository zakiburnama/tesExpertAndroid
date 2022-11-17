package com.example.faktaanime.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.faktaanime.core.domain.usecase.TourismUseCase

class FavoriteViewModel(tourismUseCase: TourismUseCase) : ViewModel() {
    val favoriteTourism = tourismUseCase.getFavoriteTourism().asLiveData()
}

