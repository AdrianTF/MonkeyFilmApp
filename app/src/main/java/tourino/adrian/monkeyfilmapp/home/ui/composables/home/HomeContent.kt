package tourino.adrian.monkeyfilmapp.home.ui.composables.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import tourino.adrian.monkeyfilmapp.home.ui.FilmViewModel

@Composable
fun HomeContent(
    navController: NavHostController,
    filmViewModel: FilmViewModel
) {
    LazyColumn {
        items(filmViewModel.filmList.value!!.size) { index ->
            val film = filmViewModel.filmList.value!![index]
            ExpandableCard(
                selectedFilm = film,
                navController = navController,
            )
        }
        item { Spacer(modifier = Modifier.height(50.dp)) }
    }
}