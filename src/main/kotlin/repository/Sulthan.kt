package repository

import modal.Movie
import network.TYPE_MOVIES_NOW_PLAYING
import network.buildMovieListType

fun getNowPlayingMovies(): List<Movie> {
    return buildMovieListType(TYPE_MOVIES_NOW_PLAYING)
}