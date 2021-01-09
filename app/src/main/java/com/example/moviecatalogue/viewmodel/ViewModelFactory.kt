package com.example.moviecatalogue.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviecatalogue.data.FilmRepository
import com.example.moviecatalogue.di.Injection
import com.example.moviecatalogue.ui.bookmarkmovie.BookmarkMovieViewModel
import com.example.moviecatalogue.ui.bookmarktvshow.BookmarkTVShowViewModel
import com.example.moviecatalogue.ui.detail.DetailFilmViewModel
import com.example.moviecatalogue.ui.movie.MovieViewModel
import com.example.moviecatalogue.ui.tvshow.TVShowViewModel

class ViewModelFactory private constructor(private val mFilmRepository: FilmRepository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context))
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                return MovieViewModel(mFilmRepository) as T
            }
            modelClass.isAssignableFrom(TVShowViewModel::class.java) -> {
                return TVShowViewModel(mFilmRepository) as T
            }
            modelClass.isAssignableFrom(DetailFilmViewModel::class.java) -> {
                return DetailFilmViewModel(mFilmRepository) as T
            }
            modelClass.isAssignableFrom(BookmarkMovieViewModel::class.java) -> {
                return BookmarkMovieViewModel(mFilmRepository) as T
            }
            modelClass.isAssignableFrom(BookmarkTVShowViewModel::class.java) -> {
                return BookmarkTVShowViewModel(mFilmRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}