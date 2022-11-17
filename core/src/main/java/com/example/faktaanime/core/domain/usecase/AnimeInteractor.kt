package com.example.faktaanime.core.domain.usecase

import com.example.faktaanime.core.domain.model.Anime
import com.example.faktaanime.core.domain.repository.IAnimeRepository

class AnimeInteractor(private val animeRepository: IAnimeRepository): AnimeUseCase {

    override fun getAllAnime() = animeRepository.getAllAnime()

    override fun getFavoriteAnime() = animeRepository.getFavoriteAnime()

    override fun setFavoriteAnime(anime: Anime, state: Boolean) = animeRepository.setFavoriteAnime(anime, state)
}