package com.example.faktaanime.di

import com.example.faktaanime.core.domain.usecase.AnimeInteractor
import com.example.faktaanime.core.domain.usecase.AnimeUseCase
import com.example.faktaanime.ui.detail.DetailAnimeViewModel
import com.example.faktaanime.ui.favorite.FavoriteViewModel
import com.example.faktaanime.ui.home.HomeViewModel
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