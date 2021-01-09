package com.example.moviecatalogue.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FilmResponse(
    var id: Int,
    var title: String,
    var rating: Double,
    var releaseDate: String,
    var language: String,
    var description: String,
    var imagePath: String,
    var genres: List<GenreResponse>?,
    var type: Int,
) : Parcelable
