package com.example.faktaanime

import android.app.Application
import com.example.faktaanime.core.di.databaseModule
import com.example.faktaanime.core.di.networkModule
import com.example.faktaanime.core.di.repositoryModule
import com.example.faktaanime.di.useCaseModule
import com.example.faktaanime.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}