package com.example.moviecatalogue.ui.movie

import com.example.moviecatalogue.data.source.local.entity.FilmEntity

interface MovieFragmentCallback {
    fun onShareClick(movie: FilmEntity)

    fun onItemClick(movie: FilmEntity)
}
