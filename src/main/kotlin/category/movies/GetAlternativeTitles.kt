package category.movies

import network.MOVIE_ID
import repository.Repository

fun main() {

    val repository = Repository()
    val movieAlternativeTitlesList = repository.getAlternativeTitles(MOVIE_ID)

    movieAlternativeTitlesList.forEach { titles ->
        val alternativeTitles = titles.title
        println(alternativeTitles)
    }
}