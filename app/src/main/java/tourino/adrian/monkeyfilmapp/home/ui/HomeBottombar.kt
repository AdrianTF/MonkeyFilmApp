package tourino.adrian.monkeyfilmapp.home.ui

import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import tourino.adrian.monkeyfilmapp.ui.theme.Purple500

@Composable
fun BottomNavigationBar(navigateToHome: () -> Unit, navigateToFav: () -> Unit) {
    BottomNavigation(backgroundColor = Purple500) {
        BottomNavigationItem(
            selected = false,
            onClick = {
                navigateToHome()
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "home",
                    Modifier.size(30.dp),
                    tint = Color.White
                )
            },
            label = { Text(text = "Home") },
            alwaysShowLabel = true
        )
        BottomNavigationItem(
            selected = false,
            onClick = { navigateToFav() },
            icon = {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "fav",
                    Modifier.size(30.dp),
                    tint = Color.White
                )
            },
            label = { Text(text = "Favoritas") },
            alwaysShowLabel = true
        )
    }
}