package tourino.adrian.monkeyfilmapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import tourino.adrian.monkeyfilmapp.composables.SimpleScaffold
import tourino.adrian.monkeyfilmapp.details.ui.DetailsScreen
import tourino.adrian.monkeyfilmapp.home.ui.AddFilmContent
import tourino.adrian.monkeyfilmapp.home.ui.FilmViewModel
import tourino.adrian.monkeyfilmapp.home.ui.HomeScreen
import tourino.adrian.monkeyfilmapp.login.ui.LoginScreen
import tourino.adrian.monkeyfilmapp.login.ui.LoginViewModel
import tourino.adrian.monkeyfilmapp.model.Routes
import tourino.adrian.monkeyfilmapp.register.ui.RegisterScreen

@Composable
fun NavController() {
    var filmViewModel = FilmViewModel()
    filmViewModel.getUserFilms()

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.LoginActivity.route) {
        composable(route = Routes.LoginActivity.route) {
            LoginScreen(navController, LoginViewModel())
        }

        composable(route = Routes.RegisterActivity.route) {
            RegisterScreen(navController /*,filmViewModel*/)
        }

        composable(route = Routes.HomeActivity.route) {
            HomeScreen(navController ,filmViewModel)
        }

        composable(route = Routes.AddFilmActivity.route) {
            SimpleScaffold(
                navController = navController,
                content = { AddFilmContent(navController) })
        }

        composable(
            route = Routes.DetailsActivity.route, arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("nota") { type = NavType.IntType },
                navArgument("imagen") { type = NavType.IntType },
                navArgument("descripcion") { type = NavType.StringType },
                navArgument("genres") { type = NavType.StringType },
            )
        ) { backStackEntry ->
            SimpleScaffold(navController = navController, content = {
                DetailsScreen(
                    nombre = backStackEntry.arguments?.getString("name"),
                    puntuacion = backStackEntry.arguments?.getInt("nota"),
                    imagen = backStackEntry.arguments?.getInt("imagen"),
                    descripcion = backStackEntry.arguments?.getString("descripcion"),
                    generos = backStackEntry.arguments?.getString("genres"),
                )
            })
        }
    }
}
