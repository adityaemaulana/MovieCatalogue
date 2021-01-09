package com.example.moviecatalogue.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviecatalogue.data.source.local.entity.GenreEntity
import com.example.moviecatalogue.databinding.ItemGenreBinding

class DetailGenreAdapter : RecyclerView.Adapter<DetailGenreAdapter.DetailGenreVH>() {
    private val listGenres = ArrayList<GenreEntity>()

    fun setGenres(genres: List<GenreEntity>?) {
        if (genres == null) return
        this.listGenres.clear()
        this.listGenres.addAll(genres)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailGenreVH {
        val itemGenreBinding =
            ItemGenreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailGenreVH(itemGenreBinding)
    }

    override fun onBindViewHolder(holder: DetailGenreVH, position: Int) {
        val genre = listGenres[position]
        holder.bind(genre)
    }

    override fun getItemCount(): Int = listGenres.size

    class DetailGenreVH(private val binding: ItemGenreBinding) :
        RecyclerView.ViewHolder(binding.chipGenre) {
        fun bind(genre: GenreEntity) {
            binding.chipGenre.text = genre.name
        }
    }
}