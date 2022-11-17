package com.example.faktaanime.di

import com.example.faktaanime.core.domain.usecase.TourismInteractor
import com.example.faktaanime.core.domain.usecase.TourismUseCase
import com.example.faktaanime.detail.DetailTourismViewModel
import com.example.faktaanime.favorite.FavoriteViewModel
import com.example.faktaanime.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<TourismUseCase> { TourismInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { DetailTourismViewModel(get()) }
}