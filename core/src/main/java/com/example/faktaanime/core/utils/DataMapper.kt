package com.example.faktaanime.core.utils

import com.example.faktaanime.core.data.source.local.entity.AnimeEntity
import com.example.faktaanime.core.data.source.remote.response.AnimeResponse
import com.example.faktaanime.core.domain.model.Anime

object DataMapper {
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