package tourino.adrian.monkeyfilmapp.home.ui

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import tourino.adrian.monkeyfilmapp.home.ui.composables.FAB
import tourino.adrian.monkeyfilmapp.home.ui.composables.favorite.FavoriteContent
import tourino.adrian.monkeyfilmapp.home.ui.composables.home.HomeContent
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

