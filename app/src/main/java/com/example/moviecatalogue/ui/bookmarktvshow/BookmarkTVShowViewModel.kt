package com.example.moviecatalogue.ui.bookmarktvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.moviecatalogue.data.FilmRepository
import com.example.moviecatalogue.data.source.local.entity.FilmEntity
import com.example.moviecatalogue.utils.Constants.Companion.TYPE_TVSHOW

class BookmarkTVShowViewModel(private val filmRepository: FilmRepository) : ViewModel() {
    fun getBookmarkedShows(): LiveData<PagedList<FilmEntity>> =
        filmRepository.getBookmarkedFilms(TYPE_TVSHOW)

    fun setBookmark(filmEntity: FilmEntity) {
        val newState = !filmEntity.bookmarked
        filmRepository.setFilmBookmark(filmEntity, newState)
    }
}