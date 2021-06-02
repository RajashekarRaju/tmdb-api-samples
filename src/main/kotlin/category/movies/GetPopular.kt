package category.movies

import modal.Movie
import repository.Repository

fun main() {

    val repository = Repository()
    val popularMoviesList: List<Movie> = repository.getPopularMovies()

    popularMoviesList.forEach { movie ->
        val movieId = movie.movieId
        val movieName = movie.title
        val movieBannerUrl = movie.bannerUrl

        println("Id is $movieId, name is $movieName \n Banner == $movieBannerUrl")
    }
}