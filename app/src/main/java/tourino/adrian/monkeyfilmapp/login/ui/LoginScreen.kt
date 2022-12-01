package tourino.adrian.monkeyfilmapp.login.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import tourino.adrian.monkeyfilmapp.R
import tourino.adrian.monkeyfilmapp.model.Routes
import tourino.adrian.monkeyfilmapp.ui.theme.Purple500

@Composable
fun LoginScreen(navController: NavHostController, loginViewModel: LoginViewModel) {
    val openForgotDialog = rememberSaveable { mutableStateOf(false) }
    val isLoading: Boolean by loginViewModel.isLoading.observeAsState(initial = false)

    if(isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    } else {
        LoginContent(navController = navController, loginViewModel = loginViewModel) {
            openForgotDialog.value = true
        }
    }

    ForgotPassDialog(
        showDialog = openForgotDialog.value,
        dismissDialog = { openForgotDialog.value = false },
    )
}

@Composable
fun LoginContent(
    navController: NavHostController,
    loginViewModel: LoginViewModel,
    showDialog: () -> Unit
) {
    /*var userInput by rememberSaveable { mutableStateOf("Admin") } //Acceso rápido
    var passwordInput by rememberSaveable { mutableStateOf("admin") } //Acceso rápido*/

    val emailInput: String by loginViewModel.email.observeAsState(initial = "a@gmail.com")
    val passwordInput: String by loginViewModel.password.observeAsState(initial = "")

    var passwordVisibility by rememberSaveable { mutableStateOf(false) }
    val icon = if (passwordVisibility)
        painterResource(id = R.drawable.design_ic_visibility_off)
    else
        painterResource(id = R.drawable.design_ic_visibility)

    Surface(
        shape = RoundedCornerShape(5.dp),
        color = Color.White
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "logo",
                        modifier = Modifier.align(CenterVertically)
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp, bottom = 40.dp)
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
                Spacer(modifier = Modifier.height(20.dp))
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = emailInput,
                    onValueChange = {
                        loginViewModel.onLoginChanged(email = it, password = passwordInput)
                    },
                    label = {
                        Text(
                            text = "Email",
                            modifier = Modifier.padding(5.dp)
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Rounded.Person,
                            contentDescription = "User",
                            tint = Color.White,
                            modifier = Modifier
                                .background(Purple500)
                                .padding(20.dp)
                                .width(20.dp)
                                .height(20.dp)
                        )
                    }
                )
                Spacer(modifier = Modifier.height(20.dp))
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = passwordInput,
                    onValueChange = {
                        loginViewModel.onLoginChanged(email = emailInput, password = it)
                    },
                    label = { Text(text = "Password", modifier = Modifier.padding(5.dp)) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Rounded.Lock,
                            contentDescription = "Password",
                            tint = Color.White,
                            modifier = Modifier
                                .background(Purple500)
                                .padding(20.dp)
                                .width(20.dp)
                                .height(20.dp)
                        )
                    },
                    trailingIcon = {
                        Icon(
                            painter = icon,
                            contentDescription = "Password",
                            tint = Purple500,
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clickable {
                                    passwordVisibility = !passwordVisibility
                                }
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    ),
                    visualTransformation = if (passwordVisibility) VisualTransformation.None
                    else PasswordVisualTransformation()
                )
                Spacer(modifier = Modifier.height(50.dp))

                Box(modifier = Modifier.padding(20.dp, 0.dp, 20.dp, 0.dp)) {
                    Button(
                        onClick = {
                            loginViewModel.onButtonLoginPress(navController) //await?
                        },
                        shape = RoundedCornerShape(5.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text(text = "Entrar", fontSize = 20.sp)
                    }
                }
                Spacer(Modifier.height(10.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "¿Aún no tienes cuenta? ¡REGISTRATE!",
                        textAlign = TextAlign.Center,
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier.clickable {
                            navController.navigate(Routes.RegisterActivity.route)
                        }
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "¡He olvidado la contraseña!",
                        textAlign = TextAlign.Center,
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier.clickable {
                            showDialog()
                        }
                    )
                }
            }
        }
    }
}