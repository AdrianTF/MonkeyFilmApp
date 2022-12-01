package tourino.adrian.monkeyfilmapp.home.data

import android.util.Log
import tourino.adrian.monkeyfilmapp.home.data.network.FilmService
import tourino.adrian.monkeyfilmapp.model.MediaModel

class FilmRepository {
    private val api = FilmService()

    suspend fun getFilms() : List<MediaModel> {
        val files = api.getFilms()
        Log.i("DAM", "$files")
        return files
    }
}