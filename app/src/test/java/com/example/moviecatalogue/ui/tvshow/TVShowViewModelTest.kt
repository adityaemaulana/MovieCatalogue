package com.example.moviecatalogue.ui.tvshow

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class TVShowViewModelTest {
    private lateinit var viewModel: TVShowViewModel

    @Before
    fun setUp() {
        viewModel = TVShowViewModel()
    }

    @Test
    fun getShows() {
        val showEntities = viewModel.getShows()
        assertNotNull(showEntities)
        assertEquals(10, showEntities.size)
    }
}