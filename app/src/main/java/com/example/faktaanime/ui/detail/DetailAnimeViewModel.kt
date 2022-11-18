package com.example.faktaanime.ui.detail

import androidx.lifecycle.ViewModel
import com.example.faktaanime.core.domain.model.Anime
import com.example.faktaanime.core.domain.usecase.AnimeUseCase

class DetailAnimeViewModel(private val animeUseCase: AnimeUseCase) : ViewModel() {
    fun setFavoriteAnime(anime: Anime, newStatus:Boolean) =
        animeUseCase.setFavoriteAnime(anime, newStatus)
}

