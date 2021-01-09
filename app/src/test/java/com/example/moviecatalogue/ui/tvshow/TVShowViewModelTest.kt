package com.example.moviecatalogue.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.moviecatalogue.data.FilmRepository
import com.example.moviecatalogue.data.source.local.entity.FilmEntity
import com.example.moviecatalogue.utils.Constants.Companion.TYPE_TVSHOW
import com.example.moviecatalogue.vo.Resource
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
class TVShowViewModelTest {
    private lateinit var viewModel: TVShowViewModel
    private val expectedSize = 10

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<FilmEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<FilmEntity>

    @Before
    fun setUp() {
        viewModel = TVShowViewModel(filmRepository)
    }

    @Test
    fun getShows() {
        val dummyShows = Resource.success(pagedList)
        `when`(dummyShows.data?.size).thenReturn(expectedSize)
        val shows = MutableLiveData<Resource<PagedList<FilmEntity>>>()
        shows.value = dummyShows

        `when`(filmRepository.getAllFilms(TYPE_TVSHOW)).thenReturn(shows)
        val showEntities = viewModel.getShows().value?.data
        verify(filmRepository).getAllFilms(TYPE_TVSHOW)
        assertNotNull(showEntities)
        assertEquals(expectedSize, showEntities?.size)

        viewModel.getShows().observeForever(observer)
        verify(observer).onChanged(dummyShows)
    }
}