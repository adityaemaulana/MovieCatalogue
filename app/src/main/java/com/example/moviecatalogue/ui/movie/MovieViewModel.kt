package com.example.moviecatalogue.ui.movie

import androidx.lifecycle.ViewModel
import com.example.moviecatalogue.data.FilmEntity
import com.example.moviecatalogue.utils.DataDummy

class MovieViewModel : ViewModel() {
    fun getMovies(): List<FilmEntity> = DataDummy.generateDummyMovies()
}