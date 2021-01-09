package com.example.moviecatalogue.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.moviecatalogue.data.source.local.LocalDataSource
import com.example.moviecatalogue.data.source.local.entity.FilmEntity
import com.example.moviecatalogue.data.source.local.entity.FilmWithGenre
import com.example.moviecatalogue.data.source.remote.RemoteDataSource
import com.example.moviecatalogue.utils.AppExecutors
import com.example.moviecatalogue.utils.Constants.Companion.TYPE_MOVIE
import com.example.moviecatalogue.utils.DataDummy
import com.example.moviecatalogue.utils.LiveDataTestUtil
import com.example.moviecatalogue.utils.PagedListUtil
import com.example.moviecatalogue.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class FilmRepositoryTest {

    @get:Rule
    var InstantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val filmRepository = FakeFilmRepository(remote, local, appExecutors)

    private val filmResponses = DataDummy.generateRemoteDummyMovies()
    private val filmId = filmResponses[0].id
    private val type = TYPE_MOVIE
    private val delta = 0.00001

    @Test
    fun getAllFilms() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, FilmEntity>
        `when`(local.getAllFilms(type)).thenReturn(dataSourceFactory)
        filmRepository.getAllFilms(type)

        val filmEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getAllFilms(TYPE_MOVIE)
        assertNotNull(filmEntities.data)
        assertEquals(filmResponses.size.toLong(), filmEntities.data?.size?.toLong())
    }

    @Test
    fun getFilmWithGenres() {
        val dummyEntity = MutableLiveData<FilmWithGenre>()
        dummyEntity.value =
            DataDummy.generateDummyFilmWithGenres(DataDummy.generateDummyMovies()[0], false)
        `when`(local.getFilmWithGenres(filmId, type)).thenReturn(dummyEntity)

        val filmEntity = LiveDataTestUtil.getValue(filmRepository.getFilmWithGenres(filmId, type))
        verify(local).getFilmWithGenres(filmId, type)

        assertNotNull(filmEntity)
        assertEquals(filmResponses[0].title, filmEntity.data?.mFilm?.title)
        assertEquals(filmResponses[0].releaseDate, filmEntity.data?.mFilm?.releaseDate)
        assertEquals(filmResponses[0].rating, filmEntity.data?.mFilm?.rating as Double, delta)
        assertEquals(filmResponses[0].language, filmEntity.data?.mFilm?.language)
        assertEquals(filmResponses[0].description, filmEntity.data?.mFilm?.description)
        assertEquals(filmResponses[0].imagePath, filmEntity.data?.mFilm?.imagePath)
    }

    @Test
    fun getBookmarkedFilms() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, FilmEntity>
        `when`(local.getBookmarkedFilmsByType(type)).thenReturn(dataSourceFactory)
        filmRepository.getBookmarkedFilms(type)

        val filmEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getBookmarkedFilmsByType(type)
        assertNotNull(filmEntities)
        assertEquals(filmResponses.size.toLong(), filmEntities.data?.size?.toLong())
    }
}