package com.example.moviecatalogue.ui.bookmarktvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.moviecatalogue.R
import com.example.moviecatalogue.data.source.local.entity.FilmEntity
import com.example.moviecatalogue.databinding.ItemBookmarkShowBinding

class BookmarkTVShowAdapter(private val callback: BookmarkTVShowCallback) :
    PagedListAdapter<FilmEntity, BookmarkTVShowAdapter.BookmarkShowVH>(DIFF_CALLBACK) {

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkShowVH {
        val itemShowBinding =
            ItemBookmarkShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookmarkShowVH(itemShowBinding)
    }

    override fun onBindViewHolder(holder: BookmarkShowVH, position: Int) {
        val show = getItem(position)
        if (show != null) {
            holder.bind(show)
        }
    }

    fun getSwipedData(swipedPosition: Int): FilmEntity? = getItem(swipedPosition)

    inner class BookmarkShowVH(private val binding: ItemBookmarkShowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(show: FilmEntity) {
            with(binding) {
                textItemTitle.text = show.title
                textItemDescription.text = show.description
                itemView.setOnClickListener { callback.onItemClick(show) }
                Glide.with(itemView.context)
                    .load(show.imagePath)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_error)
                    .into(imgPoster)
            }
        }
    }
}