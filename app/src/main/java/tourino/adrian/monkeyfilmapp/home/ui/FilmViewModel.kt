package tourino.adrian.monkeyfilmapp.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import tourino.adrian.monkeyfilmapp.home.domain.FilmUseCase

class FilmViewModel: ViewModel() {
    private val filmUseCase = FilmUseCase()

    private var _filmList = MutableLiveData<List<MediaModel>>()
    var filmList: LiveData<List<MediaModel>> = _filmList

    private fun getList() {
        filmList = _filmList
    }

    fun getUserFilms() {
        viewModelScope.launch {
            _filmList = MutableLiveData(filmUseCase())
            getList()
        }
    }
}