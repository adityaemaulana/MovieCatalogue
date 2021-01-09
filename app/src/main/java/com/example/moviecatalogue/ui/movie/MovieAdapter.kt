package com.example.moviecatalogue.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.moviecatalogue.R
import com.example.moviecatalogue.data.FilmEntity
import com.example.moviecatalogue.databinding.ItemMovieBinding
import com.example.moviecatalogue.ui.detail.DetailFilmActivity

class MovieAdapter(private val callback: MovieFragmentCallback) :
    RecyclerView.Adapter<MovieAdapter.MovieVH>() {
    private var listMovies = ArrayList<FilmEntity>()

    fun setMovies(films: List<FilmEntity>?) {
        if (films == null) return
        this.listMovies.clear()
        this.listMovies.addAll(films)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieVH {
        val itemMovieBinding =
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieVH(itemMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieVH, position: Int) {
        val movie = listMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovies.size

    inner class MovieVH(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(film: FilmEntity) {
            with(binding) {
                textItemTitle.text = film.title
                textItemDescription.text = film.description
                itemView.setOnClickListener { callback.onItemClick(film) }
                imgShare.setOnClickListener { callback.onShareClick(film) }
                Glide.with(itemView.context)
                    .load(film.imagePath)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_error)
                    .into(imgPoster)
            }
        }
    }


}