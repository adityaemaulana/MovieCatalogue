package com.example.moviecatalogue.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.moviecatalogue.R
import com.example.moviecatalogue.data.FilmEntity
import com.example.moviecatalogue.databinding.ActivityDetailFilmBinding
import com.example.moviecatalogue.databinding.ContentDetailFilmBinding

class DetailFilmActivity : AppCompatActivity() {

    private lateinit var detailContentBinding: ContentDetailFilmBinding

    companion object {
        const val EXTRA_FILM = "extra_film"
        const val EXTRA_TYPE = "extra_type"
        const val TYPE_MOVIE = 10
        const val TYPE_TVSHOW = 11
        private const val GLIDE_ROUND_RADIUS = 20
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailFilmBinding = ActivityDetailFilmBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailFilmBinding.detailFilm

        setContentView(activityDetailFilmBinding.root)

        setSupportActionBar(activityDetailFilmBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val adapter = DetailGenreAdapter()

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailFilmViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val filmId = extras.getString(EXTRA_FILM)
            val type = extras.getInt(EXTRA_TYPE)
            viewModel.setType(type)

            if (filmId != null) {
                viewModel.setSelectedFilm(filmId)
                populateDetailFilm(viewModel.getFilm())

                val genres = viewModel.getGenres()
                adapter.setGenres(genres)
            }
        }

        with(detailContentBinding.rvGenre) {
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(this@DetailFilmActivity, RecyclerView.HORIZONTAL, false)
            setHasFixedSize(true)
            this.adapter = adapter
        }
    }

    private fun populateDetailFilm(film: FilmEntity) {
        detailContentBinding.textTitleValue.text = film.title
        detailContentBinding.textDateValue.text = film.releaseDate
        detailContentBinding.textStatusValue.text = film.status
        detailContentBinding.textLanguageValue.text = film.language
        detailContentBinding.textDescriptionValue.text = film.description

        Glide.with(this)
                .load(film.imagePath)
                .transform(RoundedCorners(GLIDE_ROUND_RADIUS))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(detailContentBinding.imagePoster)
    }
}