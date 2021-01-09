package com.example.moviecatalogue.ui.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.moviecatalogue.R
import com.example.moviecatalogue.data.source.local.entity.FilmEntity
import com.example.moviecatalogue.databinding.ItemShowBinding

class TVShowAdapter(private val callback: TVShowFragmentCallback) :
    PagedListAdapter<FilmEntity, TVShowAdapter.ShowVH>(DIFF_CALLBACK) {

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowVH {
        val itemShowBinding =
            ItemShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShowVH(itemShowBinding)
    }

    override fun onBindViewHolder(holder: ShowVH, position: Int) {
        val show = getItem(position)
        if (show != null) {
            holder.bind(show)
        }
    }

    inner class ShowVH(private val binding: ItemShowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(show: FilmEntity) {
            with(binding) {
                textItemTitle.text = show.title
                textItemDescription.text = show.description
                itemView.setOnClickListener { callback.onItemClick(show) }
                imgShare.setOnClickListener { callback.onShareClick(show) }
                Glide.with(itemView.context)
                    .load(show.imagePath)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_error)
                    .into(imgPoster)
            }
        }
    }
}