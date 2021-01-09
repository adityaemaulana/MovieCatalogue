package com.example.moviecatalogue.ui.tvshow

import androidx.lifecycle.ViewModel
import com.example.moviecatalogue.data.FilmEntity
import com.example.moviecatalogue.utils.DataDummy

class TVShowViewModel : ViewModel() {
    fun getShows() : List<FilmEntity> = DataDummy.generateDummyTVShows()
}