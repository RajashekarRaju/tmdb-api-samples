package category.movies


import modal.MovieDetails
import repository.Repository

fun main() {

    val repository = Repository()
    val movie: MovieDetails? = repository.getMovieDetails(27576)

    val runtime = movie?.runtime
    val hours: Int? = runtime?.div(60)
    val minutes: Int? = runtime?.rem(60)

    println("The Movie runtime:$hours:$minutes")
}