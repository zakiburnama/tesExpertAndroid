package com.example.faktaanime.maps

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.faktaanime.core.domain.usecase.AnimeUseCase

class MapsViewModel(animeUseCase: AnimeUseCase) : ViewModel() {
    val anime = animeUseCase.getAllAnime().asLiveData()
}

