package com.example.moviecatalogue.data

import androidx.lifecycle.LiveData
import com.example.moviecatalogue.data.source.local.entity.FilmEntity

interface FilmDataSource {
    fun getAllFilms(type: Int): LiveData<List<FilmEntity>>

    fun getFilmWithGenres(filmId: Int, type: Int): LiveData<FilmEntity>
}