package com.example.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.moviecatalogue.data.source.local.LocalDataSource
import com.example.moviecatalogue.data.source.local.entity.FilmEntity
import com.example.moviecatalogue.data.source.local.entity.FilmWithGenre
import com.example.moviecatalogue.data.source.local.entity.GenreEntity
import com.example.moviecatalogue.data.source.remote.ApiResponse
import com.example.moviecatalogue.data.source.remote.RemoteDataSource
import com.example.moviecatalogue.data.source.remote.response.FilmResponse
import com.example.moviecatalogue.data.source.remote.response.GenreResponse
import com.example.moviecatalogue.utils.AppExecutors
import com.example.moviecatalogue.vo.Resource

class FilmRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : FilmDataSource {

    companion object {
        private const val INITIAL_LOAD_SIZE = 4
        private const val PAGE_SIZE = 4

        @Volatile
        private var instance: FilmRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): FilmRepository =
            instance ?: synchronized(this) {
                instance ?: FilmRepository(remoteData, localData, appExecutors)
            }
    }

    override fun getAllFilms(type: Int): LiveData<Resource<PagedList<FilmEntity>>> {
        return object :
            NetworkBoundResource<PagedList<FilmEntity>, List<FilmResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<FilmEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(INITIAL_LOAD_SIZE)
                    .setPageSize(PAGE_SIZE)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllFilms(type), config).build()
            }

            override fun shouldFetch(data: PagedList<FilmEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<FilmResponse>>> =
                remoteDataSource.getAllFilms(type)

            public override fun saveCallResult(filmResponses: List<FilmResponse>) {
                val listFilm = ArrayList<FilmEntity>()
                for (response in filmResponses) {
                    val filmEntity = FilmEntity(
                        response.id,
                        response.title,
                        response.rating,
                        response.releaseDate,
                        response.language,
                        response.description,
                        response.imagePath,
                        type
                    )
                    listFilm.add(filmEntity)
                }

                localDataSource.insertFilms(listFilm)
            }
        }.asLiveData()
    }

    override fun getFilmWithGenres(filmId: Int, type: Int): LiveData<Resource<FilmWithGenre>> {
        return object : NetworkBoundResource<FilmWithGenre, List<GenreResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<FilmWithGenre> =
                localDataSource.getFilmWithGenres(filmId, type)

            override fun shouldFetch(data: FilmWithGenre?): Boolean =
                data?.mGenres == null || data.mGenres.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<GenreResponse>>> =
                remoteDataSource.getGenresFromFilm(filmId, type)


            override fun saveCallResult(genreResponses: List<GenreResponse>) {
                val listGenre = ArrayList<GenreEntity>()

                for (response in genreResponses) {
                    val genreEntity = GenreEntity(
                        0, response.id, filmId, response.name
                    )
                    listGenre.add(genreEntity)
                }

                localDataSource.insertGenres(listGenre)
            }
        }.asLiveData()
    }

    override fun getBookmarkedFilms(type: Int): LiveData<PagedList<FilmEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(INITIAL_LOAD_SIZE)
            .setPageSize(PAGE_SIZE)
            .build()
        return LivePagedListBuilder(localDataSource.getBookmarkedFilmsByType(type), config).build()
    }

    override fun setFilmBookmark(film: FilmEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setFilmBookmark(film, state) }
}