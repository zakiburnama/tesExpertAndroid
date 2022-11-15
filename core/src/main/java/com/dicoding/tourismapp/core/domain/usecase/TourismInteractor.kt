package com.dicoding.tourismapp.core.domain.usecase

import com.dicoding.tourismapp.core.domain.model.Anime
import com.dicoding.tourismapp.core.domain.model.Tourism
import com.dicoding.tourismapp.core.domain.repository.ITourismRepository

class TourismInteractor(private val tourismRepository: ITourismRepository): TourismUseCase {

    override fun getAllTourism() = tourismRepository.getAllTourism()

    override fun getFavoriteTourism() = tourismRepository.getFavoriteTourism()

    override fun setFavoriteTourism(anime: Anime, state: Boolean) = tourismRepository.setFavoriteTourism(anime, state)
}