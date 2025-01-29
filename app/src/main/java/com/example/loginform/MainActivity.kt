package com.example.loginform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginform.ui.composable.OutLinedTextFieldWithTrailingIcon
import com.example.loginform.ui.theme.LoginFormTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginFormTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginFormApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LoginFormApp(modifier: Modifier = Modifier) {
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column (
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp),

        verticalArrangement = Arrangement.spacedBy(8.dp)

    ){
        Text(
            text = "Login",
            fontSize = 28.sp,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 18.dp)
        )
        OutLinedTextFieldWithTrailingIcon(
            stringResource(R.string.username),
            Icons.Filled.Email,
            "Email icon",
            value = userName,
            onValueChange = { userName = it },
            keyboardOptions = KeyboardOptions( keyboardType = KeyboardType.Text)
        )
        OutLinedTextFieldWithTrailingIcon(
            stringResource(R.string.password),
            Icons.Filled.Lock,
            "Password icon",
            value = password,
            onValueChange = { password = it },
            keyboardOptions = KeyboardOptions( keyboardType = KeyboardType.Password)
        )
        Button(
            modifier = modifier.fillMaxWidth(),
            onClick = {}
        ) {
            Text(stringResource(R.string.submit))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    LoginFormTheme {
        LoginFormApp()
    }
}