package com.example.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moviecatalogue.data.source.local.entity.FilmEntity
import com.example.moviecatalogue.data.FilmRepository

class DetailFilmViewModel(private val filmRepository: FilmRepository) : ViewModel() {
    private var filmId: Int = 0
    private var type = 0

    fun setType(type: Int) {
        this.type = type
    }

    fun setSelectedFilm(filmId: Int) {
        this.filmId = filmId
    }

    fun getFilmWithGenres(): LiveData<FilmEntity> =
        filmRepository.getFilmWithGenres(filmId, type)
}