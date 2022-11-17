package com.example.faktaanime.maps

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.faktaanime.core.domain.usecase.TourismUseCase

class MapsViewModel(tourismUseCase: TourismUseCase) : ViewModel() {
    val tourism = tourismUseCase.getAllTourism().asLiveData()
}

