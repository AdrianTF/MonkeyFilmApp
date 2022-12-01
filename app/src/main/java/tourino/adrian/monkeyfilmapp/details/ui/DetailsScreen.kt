package tourino.adrian.monkeyfilmapp.details.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tourino.adrian.monkeyfilmapp.R
import tourino.adrian.monkeyfilmapp.ui.theme.GoldenStar


@Composable
fun DetailsScreen(
    nombre: String?,
    puntuacion: Int?,
    imagen: Int?,
    descripcion: String?,
    generos: String?
) {
    val imageCartel = when (imagen) {
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
                    painter = painterResource(imageCartel),
                    contentDescription = "",
                    Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    contentScale = ContentScale.FillWidth
                )
            }
            Row(horizontalArrangement = Arrangement.Start, modifier = Modifier.fillMaxWidth()) {
                Column(Modifier.padding(start = 5.dp)) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = nombre!!,
                        fontSize = 30.sp,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = generos!!,
                            fontSize = 15.sp,
                            modifier = Modifier.padding(bottom = 10.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            tint = GoldenStar,
                            contentDescription = "star icon",
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            text = "$puntuacion",
                            fontSize = 20.sp,
                            textAlign = TextAlign.Start,
                            fontWeight = FontWeight.Normal,
                        )
                    }
                    Text(
                        text = descripcion!!,
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.padding(top = 10.dp)
                    )
                }
            }
        }
    }
}