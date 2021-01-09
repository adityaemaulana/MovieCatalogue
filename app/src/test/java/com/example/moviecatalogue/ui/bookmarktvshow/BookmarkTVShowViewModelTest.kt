package com.example.moviecatalogue.ui.bookmarktvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.moviecatalogue.data.FilmRepository
import com.example.moviecatalogue.data.source.local.entity.FilmEntity
import com.example.moviecatalogue.utils.Constants
import com.example.moviecatalogue.utils.Constants.Companion.TYPE_TVSHOW
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
class BookmarkTVShowViewModelTest {
    private lateinit var viewModel: BookmarkTVShowViewModel
    private val expectedSize = 10

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<PagedList<FilmEntity>>

    @Mock
    private lateinit var pagedList: PagedList<FilmEntity>

    @Before
    fun setUp() {
        viewModel = BookmarkTVShowViewModel(filmRepository)
    }

    @Test
    fun getBookmarkedShows() {
        val dummyBookmarkedShows = pagedList
        `when`(dummyBookmarkedShows.size).thenReturn(expectedSize)
        val shows = MutableLiveData<PagedList<FilmEntity>>()
        shows.value = dummyBookmarkedShows

        `when`(filmRepository.getBookmarkedFilms(TYPE_TVSHOW)).thenReturn(shows)
        val movieEntities = viewModel.getBookmarkedShows().value
        verify(filmRepository).getBookmarkedFilms(Constants.TYPE_TVSHOW)

        assertNotNull(movieEntities)
        assertEquals(expectedSize, movieEntities?.size)

        viewModel.getBookmarkedShows().observeForever(observer)
        verify(observer).onChanged(dummyBookmarkedShows)
    }
}