package com.example.moviecatalogue.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviecatalogue.data.source.local.entity.FilmEntity
import com.example.moviecatalogue.data.source.remote.response.FilmResponse
import com.example.moviecatalogue.data.source.remote.response.GenreResponse
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

    fun getAllFilms(type: Int): LiveData<ApiResponse<List<FilmResponse>>> {
        EspressoIdlingResource.increment()
        lateinit var client: Call<String>
        val resultFilm = MutableLiveData<ApiResponse<List<FilmResponse>>>()

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
                        resultFilm.value =
                            ApiResponse.success(jsonHelper.loadMovies(stringResponse as String))
                    } else if (type == TYPE_TVSHOW) {
                        resultFilm.value =
                            ApiResponse.success(jsonHelper.loadTVShows(stringResponse as String))
                    }
                    EspressoIdlingResource.decrement()
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
                resultFilm.value = ApiResponse.error(t.message.toString(), ArrayList())
            }
        })

        return resultFilm
    }

    fun getGenresFromFilm(filmId: Int, type: Int): LiveData<ApiResponse<List<GenreResponse>>> {
        EspressoIdlingResource.increment()
        lateinit var client: Call<String>
        val resultGenre = MutableLiveData<ApiResponse<List<GenreResponse>>>()

        if (type == TYPE_MOVIE) {
            client = apiService.getMovieWithGenres(filmId)
        } else if (type == TYPE_TVSHOW) {
            client = apiService.getTVShowWithGenres(filmId)
        }

        client.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful) {
                    val stringResponse = response.body()
                    resultGenre.value = ApiResponse.success(
                        jsonHelper.loadFilmWithGenres(
                            stringResponse as String,
                            type
                        ).genres as List<GenreResponse>
                    )
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
                resultGenre.value = ApiResponse.error(t.message.toString(), ArrayList())
            }

        })

        return resultGenre
    }
}