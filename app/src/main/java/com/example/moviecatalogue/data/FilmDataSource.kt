package com.example.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.moviecatalogue.data.source.local.entity.FilmEntity
import com.example.moviecatalogue.data.source.local.entity.FilmWithGenre
import com.example.moviecatalogue.vo.Resource

interface FilmDataSource {
    fun getAllFilms(type: Int): LiveData<Resource<PagedList<FilmEntity>>>

    fun getFilmWithGenres(filmId: Int, type: Int): LiveData<Resource<FilmWithGenre>>

    fun getBookmarkedFilms(type: Int): LiveData<PagedList<FilmEntity>>

    fun setFilmBookmark(film: FilmEntity, state: Boolean)
}