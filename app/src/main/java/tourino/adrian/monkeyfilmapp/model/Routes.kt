package tourino.adrian.monkeyfilmapp.model

sealed class Routes(val route: String) {
    object LoginActivity : Routes("loginActivity")
    object RegisterActivity : Routes("registerActivity")
    object HomeActivity : Routes("homeActivity")
    object AddFilmActivity : Routes("addFilmActivity")
    object DetailsActivity :
        Routes("detailsActivity/{name}/{nota}/{imagen}/{descripcion}/{genres}") {
        fun createRoute(film: MediaModel) =
            "detailsActivity/${film.title}/${film.score}/${film.catel}/${film.description}/${film.genres()}"
    }
}