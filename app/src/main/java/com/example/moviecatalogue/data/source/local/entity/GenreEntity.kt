package com.example.moviecatalogue.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.*

@Entity(
    tableName = "genreentities",
    foreignKeys = [ForeignKey(
        entity = FilmEntity::class,
        parentColumns = ["filmId"],
        childColumns = ["filmId"]
    )],
    indices = [Index(value = ["id"]),
        Index(value = ["filmId"])]
)
data class GenreEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @NonNull
    @ColumnInfo(name = "genreId")
    val genreId: Int,

    @NonNull
    @ColumnInfo(name = "filmId")
    var filmId: Int,

    @NonNull
    @ColumnInfo(name = "title")
    var name: String
)
