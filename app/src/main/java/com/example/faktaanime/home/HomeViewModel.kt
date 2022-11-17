package com.example.faktaanime.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.faktaanime.core.domain.usecase.AnimeUseCase

class HomeViewModel(animeUseCase: AnimeUseCase) : ViewModel() {
    val anime = animeUseCase.getAllAnime().asLiveData()
}

