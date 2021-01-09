package com.example.moviecatalogue.data.source.remote

import android.util.Log
import com.example.moviecatalogue.data.source.remote.response.FilmResponse
import com.example.moviecatalogue.data.source.remote.retrofit.ApiConfig
import com.example.moviecatalogue.utils.Constants.Companion.TYPE_MOVIE
import com.example.moviecatalogue.utils.Constants.Companion.TYPE_TVSHOW
import com.example.moviecatalogue.utils.EspressoIdlingResource
import com.example.moviecatalogue.utils.JsonHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null
        private val apiService = ApiConfig.getApiService()
        private const val TAG = "RemoteDataSource"

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper)
            }
    }

    fun getAllFilms(type: Int, callback: LoadFilmsCallback) {
        EspressoIdlingResource.increment()
        lateinit var client: Call<String>

        if (type == TYPE_MOVIE) {
            client = apiService.getMovies()
        } else if (type == TYPE_TVSHOW) {
            client = apiService.getTVShows()
        }

        client.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful) {
                    val stringResponse = response.body()

                    if (type == TYPE_MOVIE) {
                        callback.onAllFilmsReceived(jsonHelper.loadMovies(stringResponse as String))
                    } else if (type == TYPE_TVSHOW) {
                        callback.onAllFilmsReceived(jsonHelper.loadTVShows(stringResponse as String))
                    }
                    EspressoIdlingResource.decrement()
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }

    fun getFilmWithGenres(id: Int, type: Int, callback: LoadFilmWithGenresCallback) {
        EspressoIdlingResource.increment()
        lateinit var client: Call<String>

        if (type == TYPE_MOVIE) {
            client = apiService.getMovieWithGenres(id)
        } else if (type == TYPE_TVSHOW) {
            client = apiService.getTVShowWithGenres(id)
        }

        client.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful) {
                    val stringResponse = response.body()
                    callback.onFilmWithGenresReceived(jsonHelper.loadFilmWithGenres(stringResponse as String, type))
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })
    }

    interface LoadFilmsCallback {
        fun onAllFilmsReceived(filmResponse: List<FilmResponse>)
    }

    interface LoadFilmWithGenresCallback {
        fun onFilmWithGenresReceived(filmResponse: FilmResponse)
    }
}