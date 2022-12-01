package tourino.adrian.monkeyfilmapp.home.domain

import tourino.adrian.monkeyfilmapp.home.data.FilmRepository
import tourino.adrian.monkeyfilmapp.model.MediaModel

class FilmUseCase {
    private val repository = FilmRepository()

    suspend operator fun invoke() : List<MediaModel> {
        return repository.getFilms()
    }
}