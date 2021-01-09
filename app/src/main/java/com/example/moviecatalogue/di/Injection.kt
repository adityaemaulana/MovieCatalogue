package com.example.moviecatalogue.di

import com.example.moviecatalogue.data.FilmRepository
import com.example.moviecatalogue.data.source.remote.RemoteDataSource
import com.example.moviecatalogue.utils.JsonHelper

object Injection {
    fun provideRepository(): FilmRepository {
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper())

        return FilmRepository.getInstance(remoteDataSource)
    }
}