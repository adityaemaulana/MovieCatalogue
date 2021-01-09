package com.example.moviecatalogue.data.source.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class FilmWithGenre(
    @Embedded
    var mFilm: FilmEntity,

    @Relation(parentColumn = "filmId", entityColumn = "filmId")
    var mGenres: List<GenreEntity>
)
