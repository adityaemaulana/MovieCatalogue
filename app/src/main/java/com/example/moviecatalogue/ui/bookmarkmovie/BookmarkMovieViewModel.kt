package com.example.moviecatalogue.ui.bookmarkmovie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.moviecatalogue.data.FilmRepository
import com.example.moviecatalogue.data.source.local.entity.FilmEntity
import com.example.moviecatalogue.utils.Constants.Companion.TYPE_MOVIE

class BookmarkMovieViewModel(private val filmRepository: FilmRepository) : ViewModel() {
    fun getBookmarkedMovies(): LiveData<PagedList<FilmEntity>> =
        filmRepository.getBookmarkedFilms(TYPE_MOVIE)

    fun setBookmark(filmEntity: FilmEntity) {
        val newState = !filmEntity.bookmarked
        filmRepository.setFilmBookmark(filmEntity, newState)
    }
}