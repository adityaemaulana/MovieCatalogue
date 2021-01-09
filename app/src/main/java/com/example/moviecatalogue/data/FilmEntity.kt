package com.example.moviecatalogue.data

data class FilmEntity(
        val filmId: String,
        var title: String,
        var status: String,
        var language: String,
        var releaseDate: String,
        var description: String,
        var imagePath: String
)
