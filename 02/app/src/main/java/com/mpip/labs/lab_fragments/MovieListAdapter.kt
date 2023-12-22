package com.mpip.labs.lab_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mpip.labs.lab_fragments.R
import com.mpip.labs.lab_fragments.model.Movie
import com.mpip.labs.lab_fragments.service.FakeApiService

class MovieListAdapter(
    private var movies: List<Movie>,
    private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<MovieListAdapter.MovieViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(movieId: String)
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val directorTextView: TextView = itemView.findViewById(R.id.directorTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.nameTextView.text = movie.id + " | " + movie.name
        holder.directorTextView.text = movie.director

        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(movie.id)
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }

}