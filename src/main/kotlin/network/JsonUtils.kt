package network

import modal.Movie
import modal.MovieAlternativeTitles
import modal.MovieDetails
import org.json.JSONException
import org.json.JSONObject
import java.util.logging.Logger


fun getJsonLatestMovieData(
    jsonResponse: String?
): Movie? {

    var movie: Movie? = null

    try {
        // Create a JSONObject from the JSON response string
        val baseJson = JSONObject(jsonResponse)

        val movieId: Int = baseJson.getInt("id")
        val title: String? = baseJson.getString("title")
        val bannerEndPoint: String? = baseJson.getString("poster_path")
        val bannerUrl: String = IMAGE_PATH_URL + bannerEndPoint

        // Create a new {@link Movie} object with required properties
        movie = Movie(movieId, title, bannerUrl)

    } catch (e: JSONException) {
        //Log.error("Problem parsing the Movie JSON results $e")
        Logger.getLogger("Problem parsing the Movie JSON results $e")
    }
    // Return the list of Movies
    return movie
}


/**
 * Return a list of [Movie] objects that has been built up from parsing a JSON response.
 */
fun getJsonMovieData(
    jsonResponse: String?
): List<Movie> {

    val movieData: MutableList<Movie> = ArrayList()

    try {
        // Create a JSONObject from the JSON response string
        val baseJson = JSONObject(jsonResponse)
        val resultsArray = baseJson.getJSONArray("results")
        for (i in 0 until resultsArray.length()) {

            // Create a JSONObject from the JSON response string
            val jsonObject = resultsArray.getJSONObject(i)

            val movieId: Int = jsonObject.getInt("id")
            val title: String? = jsonObject.getString("title")
            val bannerEndPoint: String? = jsonObject.getString("poster_path")
            val bannerUrl: String = IMAGE_PATH_URL + bannerEndPoint

            // Create a new {@link Movie} object with required properties
            val currentMovie = Movie(movieId, title, bannerUrl)
            // Add the new {@link Movie} to the list of movies.
            movieData.add(currentMovie)
        }
    } catch (e: JSONException) {
        //Log.error("Problem parsing the Movie JSON results $e")
        Logger.getLogger("Problem parsing the Movie JSON results $e")
    }
    // Return the list of Movies
    return movieData
}

/**
 *  Return MovieDetails objects that has been built up from parsing a JSON response.
 */
fun getJsonMovieDetailsData(
    jsonResponse: String?
): MovieDetails? {

    var movie: MovieDetails? = null

    try {
        // Create a JSONObject from the JSON response string
        val baseJson = JSONObject(jsonResponse)
        val runtime: Int = baseJson.getInt("runtime")

        // Create a new {@link Movie} object with required properties
        movie = MovieDetails(runtime)

    } catch (e: JSONException) {
        //Log.error("Problem parsing the Movie JSON results $e")
        Logger.getLogger("Problem parsing the Movie JSON results $e")
    }
    // Return the MovieDetails
    return movie
}

/**
 * Alternative titles
 */
fun getJsonAlternativeTitles(
    jsonResponse: String?
): List<MovieAlternativeTitles> {

    val movieData: MutableList<MovieAlternativeTitles> = ArrayList()

    try {
        // Create a JSONObject from the JSON response string
        val baseJson = JSONObject(jsonResponse)
        val resultsArray = baseJson.getJSONArray("titles")
        for (i in 0 until resultsArray.length()) {

            // Create a JSONObject from the JSON response string
            val jsonObject = resultsArray.getJSONObject(i)
            val alternativeTitle: String? = jsonObject.getString("title")

            // Create a new {@link Movie} object with required properties
            val currentMovie = MovieAlternativeTitles(alternativeTitle)
            // Add the new {@link Movie} to the list of movies.
            movieData.add(currentMovie)
        }
    } catch (e: JSONException) {
        //Log.error("Problem parsing the Movie JSON results $e")
        Logger.getLogger("Problem parsing the Movie JSON results $e")
    }
    // Return the list of Movies
    return movieData
}