package tourino.adrian.monkeyfilmapp.home.data.network

import retrofit2.Response
import retrofit2.http.GET
import tourino.adrian.monkeyfilmapp.home.data.network.response.FilmResponse

interface FilmClient {
    @GET("v3/ba19d40a-9750-4413-bd70-9c6e703cc9e9")
    suspend fun getFilms(): Response<FilmResponse>
}