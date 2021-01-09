package com.example.moviecatalogue.ui.bookmarktvshow

import com.example.moviecatalogue.data.source.local.entity.FilmEntity

interface BookmarkTVShowCallback {
    fun onItemClick(show: FilmEntity)
}