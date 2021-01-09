package com.example.moviecatalogue.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "filmentities")
data class FilmEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "filmId")
    val filmId: Int,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "rating")
    val rating: Double,

    @ColumnInfo(name = "release_date")
    val releaseDate: String,

    @ColumnInfo(name = "language")
    val language: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "imagePath")
    val imagePath: String,

    @ColumnInfo(name = "type")
    var type: Int,

    @ColumnInfo(name = "bookmarked")
    var bookmarked: Boolean = false
) {
    @Ignore
    var genres: List<GenreEntity>? = null
}
