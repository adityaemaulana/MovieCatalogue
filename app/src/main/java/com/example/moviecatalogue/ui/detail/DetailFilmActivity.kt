package com.example.moviecatalogue.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.moviecatalogue.R
import com.example.moviecatalogue.data.source.local.entity.FilmEntity
import com.example.moviecatalogue.databinding.ActivityDetailFilmBinding
import com.example.moviecatalogue.databinding.ContentDetailFilmBinding
import com.example.moviecatalogue.viewmodel.ViewModelFactory

class DetailFilmActivity : AppCompatActivity() {

    private lateinit var detailContentBinding: ContentDetailFilmBinding

    companion object {
        const val EXTRA_FILM = "extra_film"
        const val EXTRA_TYPE = "extra_type"
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

        val factory = ViewModelFactory.getInstance()
        val viewModel = ViewModelProvider(this, factory)[DetailFilmViewModel::class.java]

        detailContentBinding.progressBar.visibility = View.VISIBLE
        val extras = intent.extras

        if (extras != null) {
            val filmId = extras.getInt(EXTRA_FILM)
            val type = extras.getInt(EXTRA_TYPE)
            viewModel.setType(type)

            if (filmId != 0) {
                viewModel.setSelectedFilm(filmId)
                viewModel.getFilmWithGenres().observe(this, { film ->
                    detailContentBinding.progressBar.visibility = View.GONE
                    populateDetailFilm(film)
                    adapter.setGenres(film.genres)
                    adapter.notifyDataSetChanged()
                })
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
        detailContentBinding.textLanguageValue.text = film.language
        detailContentBinding.textDescriptionValue.text = film.description

        val ratingString = String.format("%.1f", film.rating)
        detailContentBinding.textRatingValue.text = ratingString

        Glide.with(this)
                .load(film.imagePath)
                .transform(RoundedCorners(GLIDE_ROUND_RADIUS))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(detailContentBinding.imagePoster)
    }
}