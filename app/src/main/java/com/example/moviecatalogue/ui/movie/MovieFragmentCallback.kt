package com.example.moviecatalogue.ui.movie

import com.example.moviecatalogue.data.FilmEntity

interface MovieFragmentCallback {
    fun onShareClick(movie: FilmEntity)

    fun onItemClick(movie: FilmEntity)
}
