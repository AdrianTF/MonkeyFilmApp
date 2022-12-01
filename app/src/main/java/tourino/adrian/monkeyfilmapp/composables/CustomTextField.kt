package tourino.adrian.monkeyfilmapp.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import tourino.adrian.monkeyfilmapp.R


@Composable
fun CustomTextField(
    length: Int,
    text: String,
    onValueChange: (String) -> Unit,

    ) {
    var textValue by rememberSaveable { mutableStateOf("") }

    Column {
        TextField(
            value = textValue,
            onValueChange = {
                if (it.length <= length) { //2
                    textValue = it
                    onValueChange(it)
                }
            },
            label = { Text(text) },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent
            )
        )
        Text(
            text = "${textValue.length}/$length",//3
            color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium),
            style = MaterialTheme.typography.caption,
            modifier = Modifier
                .padding(start = 16.dp)
                .align(Alignment.End) //4
        )
    }
}


@Composable
fun CustomPasswordTextField(
    length: Int,
    text: String,
    onValueChange: (String) -> Unit,
) {
    var textValue by rememberSaveable { mutableStateOf("") }
    var passwordVisibility by rememberSaveable { mutableStateOf(false) }
    val icon = if (passwordVisibility)
        painterResource(id = R.drawable.design_ic_visibility_off)
    else
        painterResource(id = R.drawable.design_ic_visibility)
    Column {
        TextField(
            value = textValue,
            onValueChange = {
                if (it.length <= length) { //2
                    textValue = it
                    onValueChange(it)
                }
            },
            label = { Text(text) },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent
            ),
            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(painter = icon, contentDescription = "Visibility icon")
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = if (passwordVisibility) VisualTransformation.None
            else PasswordVisualTransformation()

        )
        Text(
            text = "${textValue.length}/$length",//3
            color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium),
            style = MaterialTheme.typography.caption,
            modifier = Modifier
                .padding(start = 16.dp)
                .align(Alignment.End) //4
        )
    }
}