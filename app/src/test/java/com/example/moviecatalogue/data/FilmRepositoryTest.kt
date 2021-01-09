package com.example.moviecatalogue.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.moviecatalogue.data.source.remote.RemoteDataSource
import com.example.moviecatalogue.utils.Constants.Companion.TYPE_MOVIE
import com.example.moviecatalogue.utils.DataDummy
import com.example.moviecatalogue.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class FilmRepositoryTest {

    @get:Rule
    var InstantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val filmRepository = FakeFilmRepository(remote)

    private val filmResponses = DataDummy.generateRemoteDummyMovies()
    private val filmId = filmResponses[0].id
    private val type = TYPE_MOVIE
    private val delta = 0.00001

    @Test
    fun getAllFilms() {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadFilmsCallback)
                .onAllFilmsReceived(filmResponses)
            null
        }.`when`(remote).getAllFilms(eq(type), any())

        val filmEntities = LiveDataTestUtil.getValue(filmRepository.getAllFilms(type))

        verify(remote).getAllFilms(eq(type), any())

        assertNotNull(filmEntities)
        assertEquals(filmResponses.size.toLong(), filmEntities.size.toLong())
    }

    @Test
    fun getFilmWithGenres() {
        doAnswer { invocation ->
            (invocation.arguments[2] as RemoteDataSource.LoadFilmWithGenresCallback)
                .onFilmWithGenresReceived(filmResponses[0])
            null
        }.`when`(remote).getFilmWithGenres(eq(filmId), eq(type), any())

        val filmEntity = LiveDataTestUtil.getValue(filmRepository.getFilmWithGenres(filmId, type))

        verify(remote).getFilmWithGenres(eq(filmId), eq(type), any())

        assertNotNull(filmEntity)
        assertEquals(filmResponses[0].title, filmEntity.title)
        assertEquals(filmResponses[0].releaseDate, filmEntity.releaseDate)
        assertEquals(filmResponses[0].rating, filmEntity.rating, delta)
        assertEquals(filmResponses[0].language, filmEntity.language)
        assertEquals(filmResponses[0].description, filmEntity.description)
        assertEquals(filmResponses[0].imagePath, filmEntity.imagePath)
    }
}