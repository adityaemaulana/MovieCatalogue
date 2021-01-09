package com.example.moviecatalogue.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GenreResponse(
    var id: Int,
    var name: String
) : Parcelable
