package category.movies

import modal.Movie
import modal.MovieAlternativeTitles
import repository.Repository

fun main() {

    val repository = Repository()
    val movieAlternativeTitles: List<MovieAlternativeTitles> = repository.getAlternativeTitles(27576)

    movieAlternativeTitles.forEach { MovieAlternativeTitles ->
        val alternativeTitles = MovieAlternativeTitles.alternativeTitles

        println(alternativeTitles)
    }
}