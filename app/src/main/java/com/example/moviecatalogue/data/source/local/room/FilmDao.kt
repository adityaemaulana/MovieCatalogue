package com.example.moviecatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.example.moviecatalogue.data.source.local.entity.FilmEntity
import com.example.moviecatalogue.data.source.local.entity.FilmWithGenre
import com.example.moviecatalogue.data.source.local.entity.GenreEntity

@Dao
interface FilmDao {
    @Query("SELECT * FROM filmentities WHERE type = :type ORDER BY rating DESC")
    fun getFilms(type: Int): DataSource.Factory<Int, FilmEntity>

    @Query("SELECT * FROM filmentities WHERE type = :type AND bookmarked = 1")
    fun getBookmarkedFilmsByType(type: Int): DataSource.Factory<Int, FilmEntity>

    @Transaction
    @Query("SELECT * FROM filmentities WHERE filmId = :filmId AND type = :type")
    fun getFilmWithGenreById(filmId: Int, type: Int): LiveData<FilmWithGenre>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFilms(films: List<FilmEntity>)

    @Update
    fun updateFilm(film: FilmEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGenres(genres: List<GenreEntity>)

    @Update
    fun updateGenre(genre: GenreEntity)
}