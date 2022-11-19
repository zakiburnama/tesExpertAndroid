package com.example.faktaanime.core.di

import androidx.room.Room
import com.example.faktaanime.core.BuildConfig
import com.example.faktaanime.core.data.AnimeRepository
import com.example.faktaanime.core.data.source.local.LocalDataSource
import com.example.faktaanime.core.data.source.local.room.AnimeDatabase
import com.example.faktaanime.core.data.source.remote.RemoteDataSource
import com.example.faktaanime.core.data.source.remote.network.ApiService
import com.example.faktaanime.core.domain.repository.IAnimeRepository
import com.example.faktaanime.core.utils.AppExecutors
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<AnimeDatabase>().animeDao() }
    single {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("anime".toCharArray())
        val factory = SupportFactory(passphrase)
        Room.databaseBuilder(
            androidContext(),
            AnimeDatabase::class.java, "Anime.db"
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }
}

val networkModule = module {
    val loggingInterceptor =
        if (BuildConfig.DEBUG)
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        else
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)

    val hostname = "anime-facts-rest-api.herokuapp.com"
    val certificatePinner = CertificatePinner.Builder()
        .add(hostname, "sha256/im5ud9vsxaJ6mKhha1/S92p6jbFgFCdKHilO7qZIYeo=")
        .add(hostname, "sha256/JSMzqOOrtyOT1kmau6zKhgT676hGgczD5VMdRMyJZFA=")
        .add(hostname, "sha256/++MBgDH5WGvL9Bcn5Be30cRcL0f5O+NyoXuWtQdX1aI=")
        .build()

    single {
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .certificatePinner(certificatePinner)
            .build()
    }
    single {
        val API_URL = "https://anime-facts-rest-api.herokuapp.com/api/"
        val retrofit = Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<IAnimeRepository> {
        AnimeRepository(
            get(),
            get(),
            get()
        )
    }
}