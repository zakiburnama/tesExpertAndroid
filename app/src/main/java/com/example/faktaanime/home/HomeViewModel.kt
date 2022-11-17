package com.example.faktaanime.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.faktaanime.core.domain.usecase.TourismUseCase

class HomeViewModel(tourismUseCase: TourismUseCase) : ViewModel() {
    val tourism = tourismUseCase.getAllTourism().asLiveData()
}

