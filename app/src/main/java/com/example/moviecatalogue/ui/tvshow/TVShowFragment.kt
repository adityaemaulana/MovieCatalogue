package com.example.moviecatalogue.ui.tvshow

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviecatalogue.R
import com.example.moviecatalogue.data.FilmEntity
import com.example.moviecatalogue.databinding.FragmentTvShowBinding
import com.example.moviecatalogue.ui.detail.DetailFilmActivity

class TVShowFragment : Fragment(), TVShowFragmentCallback {

    private lateinit var fragmentTvShowBinding: FragmentTvShowBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(inflater, container, false)
        return fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TVShowViewModel::class.java]
            val shows = viewModel.getShows()

            val showAdapter = TVShowAdapter(this)
            showAdapter.setShows(shows)

            with(fragmentTvShowBinding.rvShow) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = showAdapter
            }
        }
    }

    override fun onShareClick(show: FilmEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setChooserTitle("Bagikan aplikasi ini sekarang.")
                .setText(resources.getString(R.string.share_text, show.title))
                .startChooser()
        }
    }

    override fun onItemClick(show: FilmEntity) {
        val intent = Intent(context, DetailFilmActivity::class.java)
        intent.putExtra(DetailFilmActivity.EXTRA_FILM, show.filmId)
        intent.putExtra(DetailFilmActivity.EXTRA_TYPE, DetailFilmActivity.TYPE_TVSHOW)
        startActivity(intent)
    }
}