package tourino.adrian.monkeyfilmapp.home.ui

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import tourino.adrian.monkeyfilmapp.R
import tourino.adrian.monkeyfilmapp.ui.theme.Purple500

@Composable
fun Toolbar(navController: NavHostController) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_title),
                style = TextStyle(
                    color = Color.White,
                    fontSize = 30.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold,
                    shadow = Shadow(
                        color = Color.LightGray,
                        offset = Offset(2.0f, 4.0f),
                        blurRadius = 2f
                    )
                ),
            )
        },
        backgroundColor = Purple500,
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Filled.Logout,
                    contentDescription = "menu icon",
                    Modifier.size(30.dp),
                    tint = Color.White
                )
            }
        },
        actions = {
            IconButton(onClick = { /*TODO User icon */ }) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "user icon",
                    Modifier.size(30.dp),
                    tint = Color.White
                )
            }
        }
    )
}