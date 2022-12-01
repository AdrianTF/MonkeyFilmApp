package tourino.adrian.monkeyfilmapp.home.data.network.response

import com.google.gson.annotations.SerializedName
import tourino.adrian.monkeyfilmapp.home.ui.MediaModel

data class FilmResponse(@SerializedName("success") val apiFilms: List<MediaModel>)
