package com.example.moviecatalogue.ui.detail

import com.example.moviecatalogue.data.FilmEntity
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailFilmViewModelTest {
    private lateinit var viewModel: DetailFilmViewModel

    private val dummyFilm = FilmEntity("m1",
            "A Star Is Born",
            "Rilis",
            "Inggris",
            "05/10/2018",
            "Seorang bintang musik country yang karirnya mulai memudar, Jackson Maine (Bradley Cooper) menemukan sebuah talenta yang sangat berbakat di dalam diri dari seorang musisi muda bernama Ally (Lady Gaga). Maine berhasil mengorbitkan Ally menjadi seorang bintang muda yang menjanjikan. Namun keduanya terlibat hubungan yang lebih jauh dari sekedar mentor dan anak didik. Seiring dengan meroketnya karir dari Ally dan dirinya, Maine mengalami dilema mengenai masalah ini.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg")
    private val filmId = dummyFilm.filmId

    @Before
    fun setUp() {
        viewModel = DetailFilmViewModel()
        viewModel.setType(DetailFilmActivity.TYPE_MOVIE)
        viewModel.setSelectedFilm(filmId)
    }

    @Test
    fun getFilm() {
        viewModel.setSelectedFilm(filmId)

        val filmEntity = viewModel.getFilm()

        assertNotNull(filmEntity)
        assertEquals(dummyFilm.title, filmEntity.title)
        assertEquals(dummyFilm.releaseDate, filmEntity.releaseDate)
        assertEquals(dummyFilm.status, filmEntity.status)
        assertEquals(dummyFilm.language, filmEntity.language)
        assertEquals(dummyFilm.description, filmEntity.description)
        assertEquals(dummyFilm.imagePath, filmEntity.imagePath)
    }

    @Test
    fun getGenres() {
        val genreEntities = viewModel.getGenres()

        assertNotNull(genreEntities)
        assertEquals(5, genreEntities.size)
    }
}