package repository

import network.APPEND_URL_ENDPOINT
import network.MOVIE_PATH
import network.assignApiKey
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