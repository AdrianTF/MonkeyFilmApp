package tourino.adrian.monkeyfilmapp.home.data

import tourino.adrian.monkeyfilmapp.home.data.network.FilmService
import tourino.adrian.monkeyfilmapp.home.ui.MediaModel

class FilmRepository {
    private val api = FilmService()

    suspend fun getFilms() : List<MediaModel> {
        val files = api.getFilms()
        return files
    }
}