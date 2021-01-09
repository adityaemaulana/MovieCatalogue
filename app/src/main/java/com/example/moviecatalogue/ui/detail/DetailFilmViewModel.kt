package com.example.moviecatalogue.ui.detail

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.moviecatalogue.data.FilmEntity
import com.example.moviecatalogue.data.GenreEntity
import com.example.moviecatalogue.utils.DataDummy

class DetailFilmViewModel : ViewModel() {
    private lateinit var filmId: String
    private lateinit var film: FilmEntity
    private var type = 0

    fun setType(type: Int) {
        this.type = type
    }

    fun setSelectedFilm(filmId: String) {
        this.filmId = filmId
    }


    fun getFilm(): FilmEntity {
        if (type == DetailFilmActivity.TYPE_MOVIE) {
            for (f in DataDummy.generateDummyMovies()) {
                if (f.filmId == filmId) film = f
            }
        } else if (type == DetailFilmActivity.TYPE_TVSHOW) {
            for (f in DataDummy.generateDummyTVShows()) {
                if (f.filmId == filmId) film = f
            }
        }

        return film
    }

    fun getGenres(): List<GenreEntity> {
        val genres = DataDummy.generateDummyGenres(filmId)
        return genres
    }
}