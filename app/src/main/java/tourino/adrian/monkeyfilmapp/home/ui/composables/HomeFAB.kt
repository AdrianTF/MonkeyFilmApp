package tourino.adrian.monkeyfilmapp.home.ui.composables

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

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