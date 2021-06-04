package network

import modal.Movie
import modal.MovieAlternativeTitles
import modal.MovieDetails
import java.net.URI
import java.net.URL

// https://api.themoviedb.org/3/movie/popular?api_key=
// https://api.themoviedb.org/3/movie/upcoming?api_key=
// https://api.themoviedb.org/3/movie/454292/similar?api_key=
// https://api.themoviedb.org/3/search/movie?api_key=&query=salt
// https://api.themoviedb.org/3/movie/454292/credits?api_key=
// https://api.themoviedb.org/3/movie/27576?api_key=

/**
 * Returns the url string with appended endpoint.
 */
fun buildMovieListType(
    movieType: String
): List<Movie> {
    val builtUrl = movieTypeUriBuilder(movieType)
    return getJsonMovieData(createUrl(builtUrl))
}

/**
 * movieType = Replace this string with "popular", "now_playing", "top_rated", "upcoming".
 *
 * https://api.themoviedb.org/3/movie/popular?api_key=YOUR_API_KEY
 */
private fun movieTypeUriBuilder(
    movieType: String
): URL {
    val builtUrl = "$MOVIE_PATH$movieType$APPEND_URL_ENDPOINT$assignApiKey"
    val baseUri = URI.create(builtUrl)
    return URL(baseUri.toString())
}

/**
 * Returns single [Movie] object properties from json response.
 */
fun buildMovieLatestType(
    movieType: String
): Movie? {
    val builtUrl = movieLatestUriBuilder(movieType)
    return getJsonLatestMovieData(createUrl(builtUrl))
}

/**
 * Builds and returns the url string for single [Movie] object.
 */
private fun movieLatestUriBuilder(
    movieType: String
): URL {
    val builtUrl = "$MOVIE_PATH$movieType$APPEND_URL_ENDPOINT$assignApiKey"
    val baseUri = URI.create(builtUrl)
    return URL(baseUri.toString())
}

/**
 * Returns the json response of type [Movie] object.
 */
fun buildDetailsMovies(
    movieId: Int
): MovieDetails? {
    val builtUrl = movieDetailsUriBuilder(movieId)
    return getJsonMovieDetailsData(createUrl(builtUrl))
}

/**
 * movieId = Replace this with different movie id's.
 * builtUrl = https://api.themoviedb.org/3/movie/27576?api_key=API_KEY
 * Creates a URI by parsing the given string.
 * returns a url
 */
private fun movieDetailsUriBuilder(
    movieId: Int
): URL {
    val builtUrl = "$MOVIE_PATH$movieId$APPEND_URL_ENDPOINT$assignApiKey"
    val baseUri = URI.create(builtUrl)
    return URL(baseUri.toString())
}

/**
 * Builds and returns List of [Movie] objects for alternative titles for single movie
 * by using id of the movie.
 */
fun buildAlternativeTitles(
    movieId: Int
): List<MovieAlternativeTitles> {
    val builtUrl = movieAlternativeTitlesUriBuilder(movieId)
    return getJsonAlternativeTitles(createUrl(builtUrl))
}

/**
 * movieId = Replace this with different movie id's.
 * builtUrl = https://api.themoviedb.org/3/movie/27576/alternative_titles?api_key=API_KEY
 * Creates a URI by parsing the given string.
 * returns a url
 */
private fun movieAlternativeTitlesUriBuilder(
    movieId: Int
): URL {
    val builtUrl = "$MOVIE_PATH$movieId$ALTERNATIVE_TITLES$APPEND_URL_ENDPOINT$assignApiKey"
    val baseUri = URI.create(builtUrl)
    return URL(baseUri.toString())
}