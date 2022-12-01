package tourino.adrian.monkeyfilmapp.home.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import tourino.adrian.monkeyfilmapp.R
import tourino.adrian.monkeyfilmapp.composables.CustomTextField
import tourino.adrian.monkeyfilmapp.ui.theme.Purple500


@Composable
fun AddFilmToolbar(navController: NavHostController) {
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
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "back icon",
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

@Composable
fun AddFilmContent(navController: NavHostController) {
    var title by rememberSaveable { mutableStateOf("") }
    var genres by rememberSaveable { mutableStateOf("") }
    var description by rememberSaveable { mutableStateOf("") }

    Box(contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp, bottom = 10.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.moviedefault),
                    contentDescription = "",
                    Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    contentScale = ContentScale.FillWidth
                )
            }
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    CustomTextField(25, "Titulo") { title = it }
                    CustomTextField(25, "Generos") { genres = it }
                    CustomTextField(100, "Descripción") { description = it }
                }
            }
            Spacer(Modifier.height(20.dp))
            Box(modifier = Modifier.padding(20.dp, 0.dp, 20.dp, 0.dp)) {
                Button(
                    onClick = {
                        //TODO Create new movie
                        navController.popBackStack()
                    },
                    shape = RoundedCornerShape(5.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text = "Añadir")
                }
            }
        }
    }
}