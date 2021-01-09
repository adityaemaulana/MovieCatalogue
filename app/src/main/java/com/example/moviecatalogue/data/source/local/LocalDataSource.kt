package com.example.moviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.example.moviecatalogue.data.source.local.entity.FilmEntity
import com.example.moviecatalogue.data.source.local.entity.FilmWithGenre
import com.example.moviecatalogue.data.source.local.entity.GenreEntity
import com.example.moviecatalogue.data.source.local.room.FilmDao

class LocalDataSource private constructor(private val mFilmDao: FilmDao) {
    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(filmDao: FilmDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(filmDao)
    }

    fun getAllFilms(type: Int): DataSource.Factory<Int, FilmEntity> = mFilmDao.getFilms(type)

    fun getBookmarkedFilmsByType(type: Int): DataSource.Factory<Int, FilmEntity> =
        mFilmDao.getBookmarkedFilmsByType(type)

    fun getFilmWithGenres(filmId: Int, type: Int): LiveData<FilmWithGenre> =
        mFilmDao.getFilmWithGenreById(filmId, type)

    fun insertFilms(films: List<FilmEntity>) = mFilmDao.insertFilms(films)

    fun insertGenres(genres: List<GenreEntity>) = mFilmDao.insertGenres(genres)

    fun setFilmBookmark(film: FilmEntity, newState: Boolean) {
        film.bookmarked = newState
        mFilmDao.updateFilm(film)
    }
}