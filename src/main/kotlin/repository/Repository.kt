package repository

import modal.Movie
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
}
