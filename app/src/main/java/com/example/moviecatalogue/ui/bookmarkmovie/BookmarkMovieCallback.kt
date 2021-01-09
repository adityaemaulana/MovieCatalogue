package com.example.moviecatalogue.ui.bookmarkmovie

import com.example.moviecatalogue.data.source.local.entity.FilmEntity

interface BookmarkMovieCallback {
    fun onItemClick(movie: FilmEntity)
}