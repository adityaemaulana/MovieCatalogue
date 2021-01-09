package com.example.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviecatalogue.data.source.local.entity.FilmEntity
import com.example.moviecatalogue.data.source.local.entity.GenreEntity
import com.example.moviecatalogue.data.source.remote.RemoteDataSource
import com.example.moviecatalogue.data.source.remote.response.FilmResponse
import com.example.moviecatalogue.data.source.remote.response.GenreResponse

class FilmRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    FilmDataSource {

    companion object {
        @Volatile
        private var instance: FilmRepository? = null

        fun getInstance(remoteData: RemoteDataSource): FilmRepository =
            instance ?: synchronized(this) {
                instance ?: FilmRepository(remoteData)
            }
    }

    override fun getAllFilms(type: Int): LiveData<List<FilmEntity>> {
        val filmResults = MutableLiveData<List<FilmEntity>>()
        remoteDataSource.getAllFilms(type, object : RemoteDataSource.LoadFilmsCallback {
            override fun onAllFilmsReceived(filmResponse: List<FilmResponse>) {
                val listFilm = ArrayList<FilmEntity>()
                for (response in filmResponse) {
                    val filmEntity = FilmEntity(
                        response.id,
                        response.title,
                        response.rating,
                        response.releaseDate,
                        response.language,
                        response.description,
                        response.imagePath,
                        null,
                        type
                    )

                    listFilm.add(filmEntity)
                }

                filmResults.postValue(listFilm)
            }

        })

        return filmResults
    }

    override fun getFilmWithGenres(filmId: Int, type: Int): LiveData<FilmEntity> {
        val filmResult = MutableLiveData<FilmEntity>()

        remoteDataSource.getFilmWithGenres(
            filmId,
            type,
            object : RemoteDataSource.LoadFilmWithGenresCallback {
                override fun onFilmWithGenresReceived(filmResponse: FilmResponse) {
                    val listGenreResponse = filmResponse.genres as List<GenreResponse>
                    val listGenreEntity = ArrayList<GenreEntity>()

                    for (response in listGenreResponse) {
                        val genreEntity = GenreEntity(
                            response.id, filmId, response.name
                        )
                        listGenreEntity.add(genreEntity)
                    }

                    val filmEntity = FilmEntity(
                        filmResponse.id,
                        filmResponse.title,
                        filmResponse.rating,
                        filmResponse.releaseDate,
                        filmResponse.language,
                        filmResponse.description,
                        filmResponse.imagePath,
                        listGenreEntity,
                        type
                    )

                    filmResult.postValue(filmEntity)
                }
            })

        return filmResult
    }
}