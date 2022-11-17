package com.example.faktaanime.core.domain.usecase

import com.example.faktaanime.core.domain.model.Anime
import com.example.faktaanime.core.domain.repository.ITourismRepository

class TourismInteractor(private val tourismRepository: ITourismRepository): TourismUseCase {

    override fun getAllTourism() = tourismRepository.getAllTourism()

    override fun getFavoriteTourism() = tourismRepository.getFavoriteTourism()

    override fun setFavoriteTourism(anime: Anime, state: Boolean) = tourismRepository.setFavoriteTourism(anime, state)
}