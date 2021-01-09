package com.example.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.moviecatalogue.data.FilmRepository
import com.example.moviecatalogue.data.source.local.entity.FilmWithGenre
import com.example.moviecatalogue.vo.Resource

class DetailFilmViewModel(private val filmRepository: FilmRepository) : ViewModel() {
    private val filmId = MutableLiveData<Int>()
    private var type = 0

    fun setType(type: Int) {
        this.type = type
    }

    fun setSelectedFilm(filmId: Int) {
        this.filmId.value = filmId
    }

    var filmWithGenre: LiveData<Resource<FilmWithGenre>> =
        Transformations.switchMap(filmId) { mFilmId ->
            filmRepository.getFilmWithGenres(mFilmId, type)
        }

    fun setBookmark() {
        val filmResource = filmWithGenre.value
        if (filmResource != null) {
            val filmWithGenre = filmResource.data

            if (filmWithGenre != null) {
                val filmEntity = filmWithGenre.mFilm
                val newState = !filmEntity.bookmarked
                filmRepository.setFilmBookmark(filmEntity, newState)
            }
        }
    }
}