package tourino.adrian.monkeyfilmapp.home.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import tourino.adrian.monkeyfilmapp.home.domain.FilmUseCase
import tourino.adrian.monkeyfilmapp.model.MediaModel

class FilmViewModel: ViewModel() {
    private val filmUseCase = FilmUseCase()

    private var _filmList = MutableLiveData<List<MediaModel>>()
    var filmList: LiveData<List<MediaModel>> = _filmList

    private fun getList() {
        filmList = _filmList
        Log.i("DAM","${filmList.value?.size ?: "Error"} ${filmList.value}")
    }

    fun getUserFilms() {
        viewModelScope.launch {
            _filmList = MutableLiveData(filmUseCase())
            getList()
        }
    }
}