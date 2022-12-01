package tourino.adrian.monkeyfilmapp.model

data class MediaModel(
    var id: Int,
    var title: String,
    var description: String,
    var catel: Int,
    var score: Int,
    var favorite: Boolean = false,
    var genre: List<String>,
    var category: String
) {
    fun like() {
        favorite = !favorite
    }

    fun genres(): String {
        var genres = ""
        for (s in genre) {
            genres += "$s "
        }
        return genres
    }
}