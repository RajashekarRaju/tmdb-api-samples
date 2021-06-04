package repository

import modal.Movie
import modal.MovieAlternativeTitles
import modal.MovieDetails
import network.*

class Repository {

    fun getPopularMovies(): List<Movie> {
        return buildMovieListType(TYPE_MOVIES_POPULAR)
    }

    fun getUpcomingMovies(): List<Movie> {
        return buildMovieListType(TYPE_MOVIES_UPCOMING)
    }

    fun getLatestMovie(): Movie? {
        return buildMovieLatestType(TYPE_MOVIES_LATEST)
    }

    fun getMovieDetails(movieId: Int): MovieDetails? {
        return buildDetailsMovies(movieId)
    }

    fun getAlternativeTitles(movieId: Int): List<MovieAlternativeTitles> {
        return buildAlternativeTitles(movieId)
    }
}
