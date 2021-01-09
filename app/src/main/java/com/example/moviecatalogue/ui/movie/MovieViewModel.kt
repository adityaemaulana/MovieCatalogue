package com.example.moviecatalogue.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moviecatalogue.data.source.local.entity.FilmEntity
import com.example.moviecatalogue.data.FilmRepository
import com.example.moviecatalogue.utils.Constants.Companion.TYPE_MOVIE

class MovieViewModel(private val filmRepository: FilmRepository) : ViewModel() {
    fun getMovies(): LiveData<List<FilmEntity>> = filmRepository.getAllFilms(TYPE_MOVIE)
}