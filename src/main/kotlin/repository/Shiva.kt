package repository

import modal.MovieAlternativeTitles
import network.*
import java.net.URI
import java.net.URL

/**
 * movieId = Replace this with different movie id's.
 * builtUrl = https://api.themoviedb.org/3/movie/27576?api_key=API_KEY
 * Creates a URI by parsing the given string.
 * returns a url
 */
fun movieDetailsUriBuilder(
    movieId: Int
): URL {
    val builtUrl = "$MOVIE_PATH$movieId$APPEND_URL_ENDPOINT$assignApiKey"
    val baseUri = URI.create(builtUrl)
    return URL(baseUri.toString())
}

//Alternative Titles
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
fun movieAlternativeTitlesUriBuilder(
    movieId: Int
): URL {
    val builtUrl = "$MOVIE_PATH$movieId$ALTERNATIVE_TITLES$APPEND_URL_ENDPOINT$assignApiKey"
    val baseUri = URI.create(builtUrl)
    return URL(baseUri.toString())
}