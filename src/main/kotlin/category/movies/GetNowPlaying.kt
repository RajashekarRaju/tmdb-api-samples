package category.movies

import modal.Movie
import repository.Repository
import repository.getNowPlayingMovies

fun main() {

    val repository = Repository()
    val getNowPLayingMoviesList: List<Movie> = getNowPlayingMovies()

    getNowPLayingMoviesList.forEach { movie ->
        val movieId = movie.movieId
        val movieName = movie.title
        val movieBannerUrl = movie.bannerUrl

        println("Id is $movieId, name is $movieName \n Banner == $movieBannerUrl")
    }
}