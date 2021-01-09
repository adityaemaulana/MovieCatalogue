package com.example.moviecatalogue.ui.bookmarktvshow

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
import com.example.moviecatalogue.databinding.FragmentBookmarkTvshowBinding
import com.example.moviecatalogue.ui.detail.DetailFilmActivity
import com.example.moviecatalogue.utils.Constants
import com.example.moviecatalogue.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar


class BookmarkTvshowFragment : Fragment(), BookmarkTVShowCallback {

    private lateinit var fragmentBookmarSBinding: FragmentBookmarkTvshowBinding
    private lateinit var viewModel: BookmarkTVShowViewModel
    private lateinit var bookmarkTVShowAdapter: BookmarkTVShowAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentBookmarSBinding = FragmentBookmarkTvshowBinding.inflate(inflater, container, false)
        return fragmentBookmarSBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(fragmentBookmarSBinding.rvBookmarkShow)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[BookmarkTVShowViewModel::class.java]

            bookmarkTVShowAdapter = BookmarkTVShowAdapter(this)

            fragmentBookmarSBinding.progressBar.visibility = View.VISIBLE
            viewModel.getBookmarkedShows().observe(viewLifecycleOwner, { shows ->
                fragmentBookmarSBinding.progressBar.visibility = View.GONE
                bookmarkTVShowAdapter.submitList(shows)
                bookmarkTVShowAdapter.notifyDataSetChanged()
            })

            with(fragmentBookmarSBinding.rvBookmarkShow) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = bookmarkTVShowAdapter
            }
        }
    }

    override fun onItemClick(show: FilmEntity) {
        val intent = Intent(context, DetailFilmActivity::class.java)
        intent.putExtra(DetailFilmActivity.EXTRA_FILM, show.filmId)
        intent.putExtra(DetailFilmActivity.EXTRA_TYPE, Constants.TYPE_TVSHOW)
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
                val filmEntity = bookmarkTVShowAdapter.getSwipedData(swipedPosition)
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