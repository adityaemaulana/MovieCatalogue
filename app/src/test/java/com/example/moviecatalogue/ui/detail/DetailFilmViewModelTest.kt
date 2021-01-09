package com.example.moviecatalogue.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.moviecatalogue.data.source.local.entity.FilmEntity
import com.example.moviecatalogue.data.source.local.entity.GenreEntity
import com.example.moviecatalogue.data.FakeFilmRepository
import com.example.moviecatalogue.data.FilmRepository
import com.example.moviecatalogue.utils.Constants.Companion.TYPE_MOVIE
import com.example.moviecatalogue.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailFilmViewModelTest {
    private lateinit var viewModel: DetailFilmViewModel
    private val dummyFilm = DataDummy.generateDummyMovies()[0]
    private val filmId = dummyFilm.filmId

    private val delta = 0.00001
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<FilmEntity>

    @Before
    fun setUp() {
        viewModel = DetailFilmViewModel(filmRepository)
        viewModel.setType(TYPE_MOVIE)
        viewModel.setSelectedFilm(filmId)

        val dummyGenre = listOf<GenreEntity>(
            GenreEntity(1, dummyFilm.filmId, "action"),
            GenreEntity(1, dummyFilm.filmId, "romance")
        )
        dummyFilm.genres = dummyGenre
    }

    @Test
    fun getFilmWithGenres() {
        val film = MutableLiveData<FilmEntity>()
        film.value = dummyFilm

        `when`(filmRepository.getFilmWithGenres(filmId, TYPE_MOVIE)).thenReturn(film)
        val filmEntity = viewModel.getFilmWithGenres().value as FilmEntity
        verify(filmRepository).getFilmWithGenres(filmId, TYPE_MOVIE)
        assertNotNull(filmEntity)
        assertEquals(dummyFilm.title, filmEntity.title)
        assertEquals(dummyFilm.releaseDate, filmEntity.releaseDate)
        assertEquals(dummyFilm.rating, filmEntity.rating, delta)
        assertEquals(dummyFilm.language, filmEntity.language)
        assertEquals(dummyFilm.description, filmEntity.description)
        assertEquals(dummyFilm.imagePath, filmEntity.imagePath)

        viewModel.getFilmWithGenres().observeForever(observer)
        verify(observer).onChanged(dummyFilm)
    }
}