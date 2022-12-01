package tourino.adrian.monkeyfilmapp.register.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import tourino.adrian.monkeyfilmapp.R
import tourino.adrian.monkeyfilmapp.composables.CustomPasswordTextField
import tourino.adrian.monkeyfilmapp.composables.CustomTextField
import tourino.adrian.monkeyfilmapp.ui.theme.Purple500

@Composable
fun RegisterScreen(navController: NavHostController) {
    var username by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordConfirm by rememberSaveable { mutableStateOf("") }

    //Variables ceckboxes
    var deportetState by rememberSaveable { mutableStateOf(false) }
    var romanceState by rememberSaveable { mutableStateOf(false) }
    var accionState by rememberSaveable { mutableStateOf(false) }
    var historicasState by rememberSaveable { mutableStateOf(false) }
    var sifiState by rememberSaveable { mutableStateOf(false) }
    var documentalState by rememberSaveable { mutableStateOf(false) }

    Box(contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier.padding(20.dp).verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 10.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.app_title),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        color = Purple500,
                        fontSize = 50.sp,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold,
                        shadow = Shadow(
                            color = Color.LightGray,
                            offset = Offset(5.0f, 10.0f),
                            blurRadius = 3f
                        )
                    ),
                )
            }
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    CustomTextField(25, "Usuario") { username = it }
                    CustomTextField(25, "Email") { email = it }
                    CustomPasswordTextField(20, "Contraseña") { password = it }
                    CustomPasswordTextField(20, "Repite la contraseña") { passwordConfirm = it }
                }
            }
            Spacer(Modifier.height(20.dp))
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
                Text(text = "Intereses", Modifier.padding(top = 10.dp, start = 20.dp))
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(0.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {

                Checkbox(
                    checked = deportetState,
                    onCheckedChange = { deportetState = !deportetState }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Deportes", Modifier.padding(top = 0.dp, end = 10.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    Arrangement.End
                ) {
                    Checkbox(
                        checked = romanceState,
                        onCheckedChange = { romanceState = !romanceState }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Romance", Modifier.padding(top = 13.dp, end = 10.dp))
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(0.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {

                Checkbox(
                    checked = accionState,
                    onCheckedChange = { accionState = !accionState }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Acción", Modifier.padding(top = 0.dp, end = 10.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    Arrangement.End
                ) {
                    Checkbox(
                        checked = historicasState,
                        onCheckedChange = { historicasState = !historicasState }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Historica", Modifier.padding(top = 13.dp, end = 10.dp))
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(0.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {

                Checkbox(
                    checked = sifiState,
                    onCheckedChange = { sifiState = !sifiState }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Si-Fi", Modifier.padding(top = 0.dp, end = 10.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    Arrangement.End
                ) {
                    Checkbox(
                        checked = documentalState,
                        onCheckedChange = { documentalState = !documentalState }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Docume.", Modifier.padding(top = 13.dp, end = 10.dp))
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Box(modifier = Modifier.padding(20.dp, 0.dp, 20.dp, 0.dp)) {
                Button(
                    onClick = {
                        //TODO Create register
                        navController.popBackStack()
                    },
                    shape = RoundedCornerShape(5.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text = "Registrarse")
                }
            }
        }
    }
}