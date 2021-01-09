package com.example.moviecatalogue.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.moviecatalogue.data.FilmRepository
import com.example.moviecatalogue.data.source.local.entity.FilmEntity
import com.example.moviecatalogue.utils.Constants.Companion.TYPE_TVSHOW
import com.example.moviecatalogue.vo.Resource

class TVShowViewModel(private val filmRepository: FilmRepository) : ViewModel() {
    fun getShows(): LiveData<Resource<PagedList<FilmEntity>>> =
        filmRepository.getAllFilms(TYPE_TVSHOW)
}