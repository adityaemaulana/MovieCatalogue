package com.example.moviecatalogue.ui.tvshow

import com.example.moviecatalogue.data.source.local.entity.FilmEntity

interface TVShowFragmentCallback {
    fun onShareClick(show: FilmEntity)

    fun onItemClick(show: FilmEntity)
}