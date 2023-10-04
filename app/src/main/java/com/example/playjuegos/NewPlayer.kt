package com.example.playjuegos

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.playjuegos.ui.theme.NaranjaDiferennte
import com.example.playjuegos.ui.theme.PlayJuegosTheme

var first :  Boolean = true
var colorName : Color = Color.White
var colorNickname : Color = Color.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewPlayer() {
        var newPlayerName by rememberSaveable { mutableStateOf("") }
        var newPlayerApellido by rememberSaveable { mutableStateOf("") }
        var newPlayerNickname by rememberSaveable { mutableStateOf("") }
        var newTelefono by rememberSaveable { mutableStateOf("") }
        var newEmail by rememberSaveable { mutableStateOf("") }

        var errorName by rememberSaveable { mutableStateOf("") }
        var errorNickname by rememberSaveable { mutableStateOf("") }
        val Peso1 = 1f
        val Peso2 = 3f
        if (first) {
            errorName = "*Obligatorio"
            errorNickname = "*Obligatorio"
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                Image(
                    painter = painterResource(id = R.drawable.account),
                    modifier = Modifier
                        .size(60.dp)
                        .weight(Peso1),
                    contentDescription = "Nombre",
                )
                TextField(
                    value = newPlayerName,
                    onValueChange = { newPlayerName = it },
                    Modifier.weight(Peso2),
                    label = { Text(text = "Nombre") },
                    shape = RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp),
                )
            }
            Row {
                Spacer(modifier = Modifier.width(120.dp))
                Text(text = errorName, color = colorName)
            }

            Row {
                Spacer(
                    modifier = Modifier
                        .width(100.dp)
                        .weight(Peso1)
                )
                TextField(
                    value = newPlayerApellido,
                    onValueChange = { newPlayerApellido = it },
                    Modifier.weight(Peso2),
                    label = { Text(text = "Apellidos") },
                    shape = RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp)
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                Spacer(
                    modifier = Modifier
                        .width(100.dp)
                        .weight(Peso1)
                )
                TextField(
                    value = newPlayerNickname,
                    onValueChange = { newPlayerNickname = it },
                    Modifier.weight(Peso2),
                    label = { Text(text = "Nickname") },
                    shape = RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp)
                )
            }
            Row {
                Spacer(modifier = Modifier.width(120.dp))
                Text(text = errorNickname, color = colorNickname)
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                Spacer(
                    modifier = Modifier
                        .size(70.dp)
                        .weight(Peso1)
                )

                Image(
                    painter = painterResource(id = R.drawable.android),
                    modifier = Modifier
                        .size(100.dp)
                        .weight(Peso2),
                    contentDescription = "Android"
                )
                Button(
                    onClick = { /*TODO*/ },
                    Modifier
                        .weight(Peso2)
                        .padding(30.dp), colors = ButtonDefaults.buttonColors(NaranjaDiferennte)
                ) {
                    Text(text = "Change")
                }
            }
            Spacer(modifier = Modifier.size(20.dp))

            Row {
                Image(
                    painter = painterResource(id = R.drawable.camera), modifier = Modifier
                        .size(60.dp)
                        .weight(Peso1),
                    contentDescription = "Telefono"
                )
                TextField(
                    value = newTelefono,
                    onValueChange = { newTelefono = it },
                    Modifier.weight(Peso2),
                    label = { Text(text = "Telefono") },
                    shape = RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp)
                )
            }
            Spacer(modifier = Modifier.size(20.dp))

            Row {
                Image(
                    painter = painterResource(id = R.drawable.email), modifier = Modifier
                        .size(60.dp)
                        .weight(Peso1),
                    contentDescription = "Correo"
                )
                TextField(
                    value = newEmail,
                    onValueChange = { newEmail = it },
                    Modifier.weight(Peso2),
                    label = { Text(text = "Email") },
                    shape = RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp)
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                Modifier.weight(Peso2)
                Spacer(modifier = Modifier.size(120.dp))
                Button(colors = ButtonDefaults.buttonColors(NaranjaDiferennte), onClick = {
                    if (newPlayerName.isBlank()) {
                        errorName = "*Error nombre obligatorio"
                        colorName = Color.Red
                    } else {
                        errorName = "*Obligatorio"
                        colorName = Color.White
                    }
                    if (newPlayerNickname.isBlank()) {
                        errorNickname = "*Error nickname obligatorio"
                        colorNickname = Color.Red
                    } else {
                        errorNickname = "*Obligatorio"
                        colorNickname = Color.Red
                    }
                    first = false
                }) {
                    Text(text = "Add new player")

                }
            }


        }
    }

