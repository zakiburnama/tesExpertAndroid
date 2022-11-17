package com.example.faktaanime.di

import com.example.faktaanime.core.domain.usecase.AnimeInteractor
import com.example.faktaanime.core.domain.usecase.AnimeUseCase
import com.example.faktaanime.detail.DetailAnimeViewModel
import com.example.faktaanime.favorite.FavoriteViewModel
import com.example.faktaanime.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<AnimeUseCase> { AnimeInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { DetailAnimeViewModel(get()) }
}