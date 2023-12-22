package com.mpip.labs.lab_fragments.service

import com.mpip.labs.lab_fragments.model.Movie

object FakeApiService {
    private val movies : ArrayList<Movie> = ArrayList()

    init {
        movies.add(
            Movie(
                "1",
                "The Godfather",
                "The aging patriarch of an organized crime dynasty transfers control",
                "Francis Ford Coppola",
                listOf("Marlon Brando", "Al Pacino")
            )
        )
        movies.add(
            Movie(
                "2",
                "The Dark Knight",
                "A caped crusader fights crime and corruption in Gotham City",
                "Christopher Nolan",
                listOf("Christian Bale", "Heath Ledger")
            )
        )
        movies.add(
            Movie(
                "3",
                "Forrest Gump",
                "A man with a low IQ witnesses and unwittingly influences historical events",
                "Robert Zemeckis",
                listOf("Tom Hanks", "Robin Wright")
            )
        )
        movies.add(
            Movie(
                "4",
                "Pulp Fiction",
                "Various interrelated stories of crime and redemption",
                "Quentin Tarantino",
                listOf("John Travolta", "Samuel L. Jackson")
            )
        )
        movies.add(
            Movie(
                "5",
                "Inception",
                "A mind-bending thriller",
                "Christopher Nolan",
                listOf("Leonardo DiCaprio", "Joseph Gordon-Levitt")
            )
        )
        movies.add(
            Movie(
                "6",
                "The Shawshank Redemption",
                "Two imprisoned men bond over a number of years",
                "Frank Darabont",
                listOf("Tim Robbins", "Morgan Freeman")
            )
        )
        movies.add(
            Movie(
                "7",
                "The Matrix",
                "A computer hacker learns from mysterious rebels about the true nature of his reality",
                "Lana Wachowski, Lilly Wachowski",
                listOf("Keanu Reeves", "Carrie-Anne Moss")
            )
        )
        movies.add(
            Movie(
                "8",
                "Schindler's List",
                "A man's efforts to save the lives of more than a thousand Polish Jews during the Holocaust",
                "Steven Spielberg",
                listOf("Liam Neeson", "Ben Kingsley")
            )
        )
        movies.add(
            Movie(
                "9",
                "Fight Club",
                "An insomniac office worker and a devil-may-care soapmaker form an underground fight club",
                "David Fincher",
                listOf("Brad Pitt", "Edward Norton")
            )
        )
        movies.add(
            Movie(
                "10",
                "Avatar",
                "A paraplegic Marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders",
                "James Cameron",
                listOf("Sam Worthington", "Zoe Saldana")
            )
        )
    }

    fun getAllMovies(): List<Movie> {
        return movies
    }

    fun addMovie(movie: Movie) {
        movies.add(movie)
    }
}