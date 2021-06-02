package category.movies

import modal.Movie
import repository.Repository

fun main() {

    val repository = Repository()
    val movie: Movie? = repository.getLatestMovie()

    val movieId = movie?.movieId
    val movieName = movie?.title
    val movieBannerUrl = movie?.bannerUrl

    println("Id is $movieId, name is $movieName \n Banner == $movieBannerUrl")
}