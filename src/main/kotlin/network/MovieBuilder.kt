package network

import modal.Movie
import java.net.URI
import java.net.URL

// https://api.themoviedb.org/3/movie/popular?api_key=
// https://api.themoviedb.org/3/movie/upcoming?api_key=
// https://api.themoviedb.org/3/movie/454292/similar?api_key=
// https://api.themoviedb.org/3/search/movie?api_key=&query=salt
// https://api.themoviedb.org/3/movie/454292/credits?api_key=
// https://api.themoviedb.org/3/movie/27576?api_key=

// popular
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
fun movieTypeUriBuilder(
    movieType: String
): URL {
    val builtUrl = "$MOVIE_PATH$movieType$APPEND_URL_ENDPOINT$assignApiKey"
    val baseUri = URI.create(builtUrl)
    return URL(baseUri.toString())
}


// popular
fun buildMovieLatestType(
    movieType: String
): Movie? {
    val builtUrl = movieLatestUriBuilder(movieType)
    println(builtUrl)
    return getJsonLatestMovieData(createUrl(builtUrl))
}

fun movieLatestUriBuilder(
    movieType: String
): URL {
    val builtUrl = "$MOVIE_PATH$movieType$APPEND_URL_ENDPOINT$assignApiKey"
    val baseUri = URI.create(builtUrl)
    return URL(baseUri.toString())
}