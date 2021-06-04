package repository

import modal.Movie
import modal.MovieAlternativeTitles
import modal.MovieDetails
import modal.People
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

    fun getNowPlayingMovies(): List<Movie> {
        return buildMovieListType(TYPE_MOVIES_NOW_PLAYING)
    }

    fun getMovieDetails(movieId: Int): MovieDetails? {
        return buildDetailsMovies(movieId)
    }

    fun getAlternativeTitles(movieId: Int): List<MovieAlternativeTitles> {
        return buildAlternativeTitles(movieId)
    }

    /** Functions from here should only have peoples information. **/
    fun getPopularPeoples(): List<People> {
        return buildPeoplePopularType(TYPE_PEOPLE_POPULAR)
    }
}
