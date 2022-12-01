package tourino.adrian.monkeyfilmapp.composables

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import tourino.adrian.monkeyfilmapp.R
import tourino.adrian.monkeyfilmapp.model.MediaModel
import tourino.adrian.monkeyfilmapp.ui.theme.GoldenStar


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FavoriteExpandableCard(selectedFilm: MediaModel, navController: NavHostController) {
    var expand by remember { mutableStateOf(false) } // Expand State
    val rotationState by animateFloatAsState(if (expand) 180f else 0f) // Rotation State
    var stroke by remember { mutableStateOf(1) } // Stroke State

    val icons =
        if (expand) painterResource(id = R.drawable.design_ic_remove)
        else painterResource(id = R.drawable.design_ic_add)
    var deleted by remember { mutableStateOf(false) }
    val imageCartel = when (selectedFilm.catel) {
        1 -> R.drawable.c1
        2 -> R.drawable.c2
        3 -> R.drawable.c3
        4 -> R.drawable.c4
        5 -> R.drawable.c5
        6 -> R.drawable.c6
        7 -> R.drawable.c7
        8 -> R.drawable.c8
        9 -> R.drawable.c9
        10 -> R.drawable.c10
        else -> R.drawable.moviedefault
    }

    Card(
        modifier = Modifier
            .animateContentSize( // Animation
                animationSpec = tween(
                    durationMillis = 400, // Animation Speed
                    easing = LinearOutSlowInEasing // Animation Type
                )
            )
            .padding(0.dp),
        backgroundColor = Color.White,
        border = BorderStroke(stroke.dp, Color.LightGray), // Stroke Width and Color
        onClick = {
            expand = !expand
            stroke = if (expand) 2 else 1
        }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween // Control the header Alignment over here.
            ) {
                Image(
                    painter = painterResource(imageCartel), contentDescription = "",
                    modifier = Modifier
                        .size(80.dp)
                        .padding(5.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier
                        .weight(.8f)
                        .padding(start = 8.dp)
                ) {
                    Text(
                        text = selectedFilm.title, // Header
                        fontSize = 20.sp,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Normal,
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            tint = GoldenStar, // Icon Color
                            contentDescription = "star icon",
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            text = "${selectedFilm.score}", // Header
                            fontSize = 16.sp,
                            textAlign = TextAlign.Start,
                            fontWeight = FontWeight.Normal,
                        )
                    }

                }
                IconButton(
                    modifier = Modifier.weight(.1f),
                    onClick = {
                        deleted = !deleted
                        selectedFilm.like()
                    },
                    enabled = !deleted
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        tint = if (!deleted) Color.Red else Color.Gray, // Icon Color
                        contentDescription = "Delete icon",
                        modifier = Modifier.size(32.dp)
                    )
                }
                IconButton(
                    modifier = Modifier
                        .rotate(rotationState)
                        .weight(.1f),
                    onClick = {
                        expand = !expand
                        stroke = if (expand) 2 else 1
                    }
                ) {
                    Icon(
                        painter = icons,
                        tint = Color.Green, // Icon Color
                        contentDescription = "More/less icon",
                        modifier = Modifier.size(32.dp)
                    )
                }
            }
            if (expand) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(imageCartel),
                            contentDescription = "",
                            Modifier
                                .fillMaxWidth()
                                .height(200.dp),
                            contentScale = ContentScale.FillWidth
                        )
                    }
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = selectedFilm.description,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Justify,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                        )
                    }
                }
            }
        }
    }

}