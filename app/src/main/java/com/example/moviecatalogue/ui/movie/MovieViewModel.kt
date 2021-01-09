package com.example.moviecatalogue.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.moviecatalogue.data.FilmRepository
import com.example.moviecatalogue.data.source.local.entity.FilmEntity
import com.example.moviecatalogue.utils.Constants.Companion.TYPE_MOVIE
import com.example.moviecatalogue.vo.Resource

class MovieViewModel(private val filmRepository: FilmRepository) : ViewModel() {
    fun getMovies(): LiveData<Resource<PagedList<FilmEntity>>> =
        filmRepository.getAllFilms(TYPE_MOVIE)
}