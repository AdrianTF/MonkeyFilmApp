package tourino.adrian.monkeyfilmapp.composables

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import tourino.adrian.monkeyfilmapp.home.ui.AddFilmToolbar

@Composable
fun SimpleScaffold(navController: NavHostController, content: @Composable () -> Unit) {
    val scaffoldState: ScaffoldState = rememberScaffoldState(
        drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    )

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { AddFilmToolbar(navController) },
    ) {
        content()
    }
}