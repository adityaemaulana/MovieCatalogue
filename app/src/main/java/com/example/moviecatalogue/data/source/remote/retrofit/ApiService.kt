package com.example.moviecatalogue.data.source.remote.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("movie/top_rated")
    fun getMovies(): Call<String>

    @GET("tv/top_rated")
    fun getTVShows(): Call<String>

    @GET("movie/{id}")
    fun getMovieWithGenres(
        @Path("id") id: Int
    ): Call<String>

    @GET("tv/{id}")
    fun getTVShowWithGenres(
        @Path("id") id: Int
    ): Call<String>
}