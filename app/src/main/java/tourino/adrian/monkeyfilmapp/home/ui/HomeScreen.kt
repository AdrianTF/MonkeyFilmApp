package tourino.adrian.monkeyfilmapp.home.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import tourino.adrian.monkeyfilmapp.composables.ExpandableCard
import tourino.adrian.monkeyfilmapp.composables.FavoriteExpandableCard
import tourino.adrian.monkeyfilmapp.model.Routes

@Composable
fun HomeScreen(
    navController: NavHostController,
    filmViewModel: FilmViewModel
) {
    val scaffoldState: ScaffoldState = rememberScaffoldState(
        drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    )

    var isNavInHome by rememberSaveable { mutableStateOf(true) }
    var isNavInFavorites by rememberSaveable { mutableStateOf(false) }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { Toolbar(navController) },
        bottomBar = {
            BottomNavigationBar(navigateToHome = {
                isNavInHome = true
                isNavInFavorites = false
            }, navigateToFav = {
                isNavInHome = false
                isNavInFavorites = true
            })
        },
        floatingActionButton = {
            if (isNavInFavorites) FAB(navController) {
                navController.navigate(Routes.AddFilmActivity.route)
            }
        }, content = {
            if (isNavInHome) HomeContent(navController, filmViewModel)
            else if (isNavInFavorites) FavoriteContent(navController, filmViewModel)
        }
    )
}

//TODO Extraer composables
@Composable
fun HomeContent(
    navController: NavHostController,
    filmViewModel: FilmViewModel
) {
    LazyColumn() {
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

@Composable
fun FavoriteContent(
    navController: NavHostController,
    filmViewModel: FilmViewModel
) {
    LazyColumn() {
        items(filmViewModel.filmList.value!!.size) { index ->
            val film = filmViewModel.filmList.value!![index]
            if (film.favorite) {
                FavoriteExpandableCard(
                    film,
                    navController
                )
            }
        }
        item { Spacer(modifier = Modifier.height(50.dp)) }
    }
}

@Composable
fun FAB(navController: NavHostController, onPressed: () -> Unit) {
    FloatingActionButton(
        onClick = {
            onPressed()
        }
    ) {
        Text(text = "+", color = Color.White, fontSize = 30.sp)
    }
}

