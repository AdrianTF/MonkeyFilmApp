package tourino.adrian.monkeyfilmapp.core.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://run.mocky.io/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}

//TODO Revisar el tema del matcher
//TODO preguntar por que se me ralentiza tanto la app
//TODO preguntar por que se me esconden las cards debajo del scaffold
