package com.example.moviecatalogue.ui.bookmarkmovie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.moviecatalogue.R
import com.example.moviecatalogue.data.source.local.entity.FilmEntity
import com.example.moviecatalogue.databinding.ItemBookmarkMovieBinding

class BookmarkMovieAdapter(private val callback: BookmarkMovieCallback) :
    PagedListAdapter<FilmEntity, BookmarkMovieAdapter.BookmarkMovieVH>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<FilmEntity>() {
            override fun areItemsTheSame(oldItem: FilmEntity, newItem: FilmEntity): Boolean {
                return oldItem.filmId == newItem.filmId
            }

            override fun areContentsTheSame(oldItem: FilmEntity, newItem: FilmEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkMovieVH {
        val itemBookmarkMovieBinding =
            ItemBookmarkMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookmarkMovieVH(itemBookmarkMovieBinding)
    }

    override fun onBindViewHolder(holder: BookmarkMovieVH, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            holder.bind(movie)
        }
    }

    fun getSwipedData(swipedPosition: Int): FilmEntity? = getItem(swipedPosition)

    inner class BookmarkMovieVH(private val binding: ItemBookmarkMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(film: FilmEntity) {
            with(binding) {
                textItemTitle.text = film.title
                textItemDescription.text = film.description
                itemView.setOnClickListener { callback.onItemClick(film) }
                Glide.with(itemView.context)
                    .load(film.imagePath)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_error)
                    .into(imgPoster)
            }
        }
    }
}