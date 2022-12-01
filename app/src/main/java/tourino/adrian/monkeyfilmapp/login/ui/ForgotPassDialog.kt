package tourino.adrian.monkeyfilmapp.login.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties


@Composable
fun ForgotPassDialog(
    showDialog: Boolean,
    dismissDialog: () -> Unit
) {
    if (showDialog) {
        var email by rememberSaveable { mutableStateOf("") }
        var isError by rememberSaveable { mutableStateOf(false) }

        Dialog(
            onDismissRequest = { dismissDialog() },
            properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)
        ) {
            Surface(
                shape = RoundedCornerShape(5.dp),
                color = Color.White
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Spacer(modifier = Modifier.height(15.dp))
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(text = "Introduzca su correo y recibirá un mensaje para restablecer la contraseña")
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        Column {
                            OutlinedTextField(
                                modifier = Modifier.fillMaxWidth(),
                                value = email,
                                onValueChange = {
                                    email = it
                                    isError = false
                                },
                                label = {
                                    Text(
                                        text = "Email",
                                        modifier = Modifier.padding(5.dp)
                                    )
                                },
                                trailingIcon = {
                                    if (isError)
                                        Icon(
                                            Icons.Filled.Error,
                                            "error",
                                            tint = MaterialTheme.colors.error
                                        )
                                }
                            )
                            if (isError) {
                                Text(
                                    text = "Correo no valido",
                                    color = MaterialTheme.colors.error,
                                    style = MaterialTheme.typography.caption,
                                    modifier = Modifier.padding(start = 16.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(40.dp))

                        Box(modifier = Modifier.padding(20.dp, 0.dp, 20.dp, 0.dp)) {
                            Button(
                                onClick = {
                                    if (email.contains('@')) {
                                        dismissDialog()
                                    } else {
                                        isError = true
                                    }
                                },
                                shape = RoundedCornerShape(5.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                            ) {
                                Text(text = "Enviar")
                            }
                        }
                        Spacer(Modifier.height(10.dp))
                    }
                }
            }
        }
    }
}