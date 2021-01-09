package com.example.moviecatalogue.utils

import android.util.Log
import com.example.moviecatalogue.data.source.remote.response.FilmResponse
import com.example.moviecatalogue.data.source.remote.response.GenreResponse
import com.example.moviecatalogue.utils.Constants.Companion.TYPE_MOVIE
import com.example.moviecatalogue.utils.Constants.Companion.TYPE_TVSHOW
import org.json.JSONException
import org.json.JSONObject

class JsonHelper {
    companion object {
        private const val IMAGE_URL = "https://image.tmdb.org/t/p/w200"
    }

    fun loadMovies(jsonString: String): List<FilmResponse> {
        val list = ArrayList<FilmResponse>()

        try {
            val responseObject = JSONObject(jsonString)
            val listArray = responseObject.getJSONArray("results")
            for (i in 0 until listArray.length()) {
                val film = listArray.getJSONObject(i)

                val id = film.getInt("id")
                val title = film.getString("title")
                val releaseDate = film.getString("release_date")
                val rating = film.getDouble("vote_average")
                val language = film.getString("original_language")
                val description = film.getString("overview")
                val imagePath = IMAGE_URL + film.getString("poster_path")


                val movieResponse = FilmResponse(
                    id,
                    title,
                    rating,
                    releaseDate,
                    language,
                    description,
                    imagePath,
                    null,
                    TYPE_MOVIE
                )

                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadTVShows(jsonString: String): List<FilmResponse> {
        val list = ArrayList<FilmResponse>()

        try {
            val responseObject = JSONObject(jsonString)
            val listArray = responseObject.getJSONArray("results")
            for (i in 0 until listArray.length()) {
                val film = listArray.getJSONObject(i)

                val id = film.getInt("id")
                val title = film.getString("name")
                val releaseDate = film.getString("first_air_date")
                val rating = film.getDouble("vote_average")
                val language = film.getString("original_language")
                val description = film.getString("overview")
                val imagePath = IMAGE_URL + film.getString("poster_path")

                val movieResponse = FilmResponse(
                    id,
                    title,
                    rating,
                    releaseDate,
                    language,
                    description,
                    imagePath,
                    null,
                    TYPE_TVSHOW
                )

                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadFilmWithGenres(jsonString: String, type: Int): FilmResponse {
        var filmResponse: FilmResponse? = null
        val genreResponses = ArrayList<GenreResponse>()

        try {
            val responseObject = JSONObject(jsonString)
            val id = responseObject.getInt("id")
            val rating = responseObject.getDouble("vote_average")
            val language = responseObject.getString("original_language")
            val description = responseObject.getString("overview")
            val imagePath = IMAGE_URL + responseObject.getString("poster_path")

            var title: String? = null
            var releaseDate: String? = null
            if (type == TYPE_MOVIE) {
                title = responseObject.getString("title")
                releaseDate = responseObject.getString("release_date")
            } else if (type == TYPE_TVSHOW) {
                title = responseObject.getString("name")
                releaseDate = responseObject.getString("first_air_date")
            }

            val listGenre = responseObject.getJSONArray("genres")
            for (i in 0 until listGenre.length()) {
                val genre = listGenre.getJSONObject(i)

                val genreId = genre.getInt("id")
                val name = genre.getString("name")
                val genreResponse = GenreResponse(genreId, name)
                genreResponses.add(genreResponse)
            }

            filmResponse = FilmResponse(
                id,
                title as String,
                rating,
                releaseDate as String,
                language,
                description,
                imagePath,
                genreResponses,
                type
            )
            Log.d("JSONHelper", filmResponse.title)
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return filmResponse as FilmResponse
    }
}