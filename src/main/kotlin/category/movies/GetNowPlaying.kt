package category.movies

import modal.Movie
import repository.Repository

fun main() {

    val repository = Repository()
    val getNowPLayingMoviesList: List<Movie> = repository.getNowPlayingMovies()

    getNowPLayingMoviesList.forEach { movie ->
        val movieId = movie.movieId
        val movieName = movie.title
        val movieBannerUrl = movie.bannerUrl

        println("Id is $movieId, name is $movieName \n Banner == $movieBannerUrl")
    }
}