package tourino.adrian.monkeyfilmapp.home.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import tourino.adrian.monkeyfilmapp.core.network.RetrofitHelper
import tourino.adrian.monkeyfilmapp.model.MediaModel

class FilmService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getFilms() : List<MediaModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(FilmClient::class.java).getFilms()
            response.body()?.apiFilms ?: emptyList()
        }
    }
}