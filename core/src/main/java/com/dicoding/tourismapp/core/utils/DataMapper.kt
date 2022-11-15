package com.dicoding.tourismapp.core.utils

import com.dicoding.tourismapp.core.data.source.local.entity.AnimeEntity
import com.dicoding.tourismapp.core.data.source.local.entity.TourismEntity
import com.dicoding.tourismapp.core.data.source.remote.response.AnimeResponse
import com.dicoding.tourismapp.core.domain.model.Anime
import com.dicoding.tourismapp.core.domain.model.Tourism

object DataMapper {
    /*
    fun mapResponsesToEntities(input: List<TourismResponse>): List<TourismEntity> {
        val tourismList = ArrayList<TourismEntity>()
        input.map {
            val tourism = TourismEntity(
                tourismId = it.id,
                description = it.description,
                name = it.name,
                address = it.address,
                latitude = it.latitude,
                longitude = it.longitude,
                like = it.like,
                image = it.image,
                isFavorite = false
            )
            tourismList.add(tourism)
        }
        return tourismList
    }

    fun mapEntitiesToDomain(input: List<TourismEntity>): List<Tourism> =
        input.map {
            Tourism(
                tourismId = it.tourismId,
                description = it.description,
                name = it.name,
                address = it.address,
                latitude = it.latitude,
                longitude = it.longitude,
                like = it.like,
                image = it.image,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Tourism) = TourismEntity(
        tourismId = input.tourismId,
        description = input.description,
        name = input.name,
        address = input.address,
        latitude = input.latitude,
        longitude = input.longitude,
        like = input.like,
        image = input.image,
        isFavorite = input.isFavorite
    )

     */


    fun mapResponsesToEntities(input: List<AnimeResponse>): List<AnimeEntity> {
        val animeList = ArrayList<AnimeEntity>()
        input.map {
            val anime = AnimeEntity(
                id = it.anime_id,
                name = it.anime_name,
                img = it.anime_img,
                isFavorite = false
            )
            animeList.add(anime)
        }
        return animeList
    }

    fun mapEntitiesToDomain(input: List<AnimeEntity>): List<Anime> =
        input.map {
            Anime(
                id = it.id,
                name = it.name,
                img = it.img,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Anime) = AnimeEntity(
        id = input.id,
        name = input.name,
        img = input.img,
        isFavorite = input.isFavorite
    )
}