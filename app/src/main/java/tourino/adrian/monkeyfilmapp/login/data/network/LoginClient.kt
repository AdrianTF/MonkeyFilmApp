package tourino.adrian.monkeyfilmapp.login.data.network

import retrofit2.Response
import retrofit2.http.GET
import tourino.adrian.monkeyfilmapp.login.data.network.response.LoginResponse

interface LoginClient {
    @GET("/v3/4fdefa5a-ee25-439b-b32f-ac7e698b71fd")
    suspend fun doLogin():Response<LoginResponse>
}