package com.mpip.labs.lab_fragments
//Izraboteno od Todorov Boris - 191096
//worst code ever
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.mpip.labs.lab_fragments.databinding.ActivityMainBinding
import com.mpip.labs.lab_fragments.model.Movie
import com.mpip.labs.lab_fragments.service.FakeApiService

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private var movieListFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main)
            as MovieListFragment?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            showAddMovieDialog()
        }
    }

    private fun showAddMovieDialog() {
        val bottomSheetView = layoutInflater.inflate(R.layout.add_movie, null)
        val context = this
        val dialog = BottomSheetDialog(this)
        dialog.setContentView(bottomSheetView)

        val editTextMovieName = bottomSheetView.findViewById<EditText>(R.id.editTextMovieName)
        val editTextMovieDescription = bottomSheetView.findViewById<EditText>(R.id.editTextDescription)
        val editTextDirector = bottomSheetView.findViewById<EditText>(R.id.editTextDirector)
        val editTextActors = bottomSheetView.findViewById<EditText>(R.id.editTextActors)
        val buttonAddMovie = bottomSheetView.findViewById<Button>(R.id.submitButton)

        buttonAddMovie.setOnClickListener {
            val movieName = editTextMovieName.text.toString()
            val description = editTextMovieDescription.text.toString()
            val director = editTextDirector.text.toString()
            val actors = editTextActors.text.split(", ")

            val newMovie = Movie((FakeApiService.getAllMovies().size+1).toString(), movieName,
                description, director, actors)

            FakeApiService.addMovie(newMovie)
            context?.let{
                Toast.makeText(it, "Change the view from the list and then back to see changes",
                    Toast.LENGTH_LONG).show()
            }
            dialog.dismiss()
        }

        dialog.show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}