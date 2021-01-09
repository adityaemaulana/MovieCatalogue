package com.example.moviecatalogue.data.source.local.entity

data class FilmEntity(
    val filmId: Int,
    var title: String,
    var rating: Double,
    var releaseDate: String,
    var language: String,
    var description: String,
    var imagePath: String,
    var genres: List<GenreEntity>?,
    var type: Int
)
