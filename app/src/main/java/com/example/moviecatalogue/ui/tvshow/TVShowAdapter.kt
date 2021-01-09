package com.example.moviecatalogue.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.moviecatalogue.R
import com.example.moviecatalogue.data.FilmEntity
import com.example.moviecatalogue.databinding.ItemShowBinding
import com.example.moviecatalogue.ui.detail.DetailFilmActivity

class TVShowAdapter(private val callback: TVShowFragmentCallback) : RecyclerView.Adapter<TVShowAdapter.ShowVH>() {
    private var listShows = ArrayList<FilmEntity>()

    fun setShows(shows: List<FilmEntity>?) {
        if (shows == null) return
        this.listShows.clear()
        this.listShows.addAll(shows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowVH {
        val itemShowBinding = ItemShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShowVH(itemShowBinding)
    }

    override fun onBindViewHolder(holder: ShowVH, position: Int) {
        val movie = listShows[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listShows.size

    inner class ShowVH(private val binding: ItemShowBinding) : RecyclerView.ViewHolder(binding.root) {
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