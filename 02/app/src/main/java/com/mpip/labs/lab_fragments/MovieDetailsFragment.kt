package com.mpip.labs.lab_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mpip.labs.lab_fragments.databinding.FragmentMovieDetailsBinding
import com.mpip.labs.lab_fragments.model.Movie


class MovieDetailsFragment : Fragment() {

    private var _binding: FragmentMovieDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movie = arguments?.getSerializable(ARG_MOVIE) as Movie?

        movie?.let {
            binding.movieId.text = it.id
            binding.movieName.text = it.name
            binding.movieDescription.text = it.description
            binding.movieDirector.text = "Director: " + it.director
            binding.movieActors.text = "Cast: \n" + it.actors.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_MOVIE = "movie"

        fun newInstance(movie: Movie): MovieDetailsFragment {
            val fragment = MovieDetailsFragment()
            val args = Bundle()
            args.putSerializable(ARG_MOVIE, movie)
            fragment.arguments = args
            return fragment
        }
    }
}