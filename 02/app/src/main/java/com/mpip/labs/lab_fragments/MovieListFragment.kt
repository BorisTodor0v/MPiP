package com.mpip.labs.lab_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mpip.labs.lab_fragments.service.FakeApiService


class MovieListFragment : Fragment(), MovieListAdapter.OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var movieListAdapter: MovieListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie_list, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        movieListAdapter = MovieListAdapter(FakeApiService.getAllMovies(), this)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = movieListAdapter


        return view
    }

    override fun onItemClick(movieId: String) {
        val selectedMovie = FakeApiService.getAllMovies().find { it.id == movieId }

        selectedMovie?.let {
            val movieDetailsFragment = MovieDetailsFragment.newInstance(it)
            parentFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_content_main, movieDetailsFragment)
                .addToBackStack(null)
                .commit()
        }

    }

}