package com.example.moviecatalogue.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.moviecatalogue.data.FilmRepository
import com.example.moviecatalogue.data.source.local.entity.FilmWithGenre
import com.example.moviecatalogue.utils.Constants.Companion.TYPE_MOVIE
import com.example.moviecatalogue.utils.DataDummy
import com.example.moviecatalogue.vo.Resource
import com.nhaarman.mockitokotlin2.verify
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

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<Resource<FilmWithGenre>>

    @Before
    fun setUp() {
        viewModel = DetailFilmViewModel(filmRepository)
        viewModel.setType(TYPE_MOVIE)
        viewModel.setSelectedFilm(filmId)
    }

    @Test
    fun getFilmWithGenres() {
        val dummyFilmWithGenres =
            Resource.success(DataDummy.generateDummyFilmWithGenres(dummyFilm, true))
        val film = MutableLiveData<Resource<FilmWithGenre>>()
        film.value = dummyFilmWithGenres

        `when`(filmRepository.getFilmWithGenres(filmId, TYPE_MOVIE)).thenReturn(film)

        viewModel.filmWithGenre.observeForever(observer)

        verify(observer).onChanged(dummyFilmWithGenres)
    }
}