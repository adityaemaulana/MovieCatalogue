package com.example.moviecatalogue.ui.bookmarkmovie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviecatalogue.R
import com.example.moviecatalogue.data.source.local.entity.FilmEntity
import com.example.moviecatalogue.databinding.FragmentBookmarkMovieBinding
import com.example.moviecatalogue.ui.detail.DetailFilmActivity
import com.example.moviecatalogue.utils.Constants
import com.example.moviecatalogue.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

class BookmarkMovieFragment : Fragment(), BookmarkMovieCallback {

    private lateinit var fragmentBookmarkMBinding: FragmentBookmarkMovieBinding
    private lateinit var viewModel: BookmarkMovieViewModel
    private lateinit var bookmarkMovieAdapter: BookmarkMovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentBookmarkMBinding =
            FragmentBookmarkMovieBinding.inflate(layoutInflater, container, false)
        return fragmentBookmarkMBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(fragmentBookmarkMBinding.rvBookmarkMovie)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[BookmarkMovieViewModel::class.java]

            bookmarkMovieAdapter = BookmarkMovieAdapter(this)

            fragmentBookmarkMBinding.progressBar.visibility = View.VISIBLE
            viewModel.getBookmarkedMovies().observe(viewLifecycleOwner, { movies ->
                fragmentBookmarkMBinding.progressBar.visibility = View.GONE
                bookmarkMovieAdapter.submitList(movies)
                bookmarkMovieAdapter.notifyDataSetChanged()
            })

            with(fragmentBookmarkMBinding.rvBookmarkMovie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = bookmarkMovieAdapter
            }
        }
    }

    override fun onItemClick(movie: FilmEntity) {
        val intent = Intent(context, DetailFilmActivity::class.java)
        intent.putExtra(DetailFilmActivity.EXTRA_FILM, movie.filmId)
        intent.putExtra(DetailFilmActivity.EXTRA_TYPE, Constants.TYPE_MOVIE)
        startActivity(intent)
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int =
            makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val filmEntity = bookmarkMovieAdapter.getSwipedData(swipedPosition)
                filmEntity?.let { viewModel.setBookmark(it) }

                val snackbar =
                    Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.message_ok) { v ->
                    filmEntity?.let { viewModel.setBookmark(it) }
                }
                snackbar.show()
            }
        }
    })
}