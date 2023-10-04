package com.example.playjuegos

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.playjuegos.ui.theme.NaranjaFuerte

@Composable
fun Preferences () {
    var estadoRadio by rememberSaveable { mutableStateOf("") }
    var context = LocalContext.current
    var sliderValue by rememberSaveable { mutableStateOf(0f) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Row {
            Text(
                text = "Elige una opcion:",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                color = Color.Black
            )
        }
        Row {
            MyRadioButton(name = estadoRadio) { estadoRadio = it }
        }
        Row {
            SimpleDiscreteSlider(sliderValue) { sliderValue = it }
        }
        Row {
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Plataformas: ", color = Color.Black)
            Spacer(modifier = Modifier.width(10.dp))
        }
        Row {
            MyFilterChip(context)
        }
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        MyFAB(seleccion = estadoRadio, context, sliderValue)
    }
}

@Composable
fun MyRadioButton(name :String, onItemSelected:(String)->Unit) {
    Column {Modifier.fillMaxSize()
        Row {
            RadioButton(selected = name == "Angry Birds", onClick = { onItemSelected ("Angry Birds") })
            Text(text = "Angry Birds", Modifier.padding(top = 12.dp), color = Color.Black)
        }
        Row {
            RadioButton(selected = name == "Dragon Fly", onClick = { onItemSelected ("Dragon Fly") })
            Text(text = "Dragon Fly", Modifier.padding(top = 12.dp), color = Color.Black)
        }
        Row {
            RadioButton(selected = name == "Hill Climbing Racing", onClick = { onItemSelected ("Hill Climbing Racing") })
            Text(text = "Hill Climbing Racing", Modifier.padding(top = 12.dp), color = Color.Black)
        }
        Row {
            RadioButton(selected = name == "Pocket Soccer", onClick = { onItemSelected ("Pocket Soccer") })
            Text(text = "Pocket Soccer", Modifier.padding(top = 12.dp), color = Color.Black)
        }
        Row {
            RadioButton(selected = name == "Radiant Defense", onClick = { onItemSelected ("Radiant Defense") })
            Text(text = "Radiant Defense", Modifier.padding(top = 12.dp), color = Color.Black)
        }
        Row {
            RadioButton(selected = name == "Ninja Jump", onClick = { onItemSelected ("Ninja Jump") })
            Text(text = "Ninja Jump", Modifier.padding(top = 12.dp), color = Color.Black)
        }
        Row {
            RadioButton(selected = name == "Air Control", onClick = { onItemSelected ("Air Control") })
            Text(text = "Air Control", Modifier.padding(top = 12.dp), color = Color.Black)
        }

    }
}
@Composable
fun SimpleDiscreteSlider(sliderValue: Float, onValueChange:(Float)->Unit) {
    val range = 0.0f..10.0f
    val steps = 9
    Slider(
        value = sliderValue,
        valueRange = range,
        steps = steps,
        onValueChange = onValueChange
    )
}
@Composable
fun MyFAB(seleccion: String, context : Context, sliderValue : Float) {
    var sliderValueInt = sliderValue.toInt()
    FloatingActionButton(modifier = Modifier.padding(16.dp),
        onClick =  {
            if (seleccion.isNotEmpty()) {
                Toast.makeText(context,"Has seleccionado : $seleccion con una puntuacion de: $sliderValueInt",
                    Toast.LENGTH_LONG
                )
                    .show()
        }else {
            Toast.makeText(context, "No has seleccionado nada", Toast.LENGTH_LONG)
                .show()
    }
        }, shape = RoundedCornerShape(50.dp), containerColor = NaranjaFuerte
        ) {
        Icon(imageVector = Icons.Filled.Check, contentDescription = "Check", tint = Color.Black)

    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyFilterChip(context: Context) {
    var selected by rememberSaveable { mutableStateOf("") }
    Row (modifier = Modifier.padding(start = 5.dp)){
        FilterChip(selected = selected == "PS4",
            onClick = { selected = "PS4"
                if (selected.isNotEmpty()) {
                    Toast.makeText(context,"Has seleccionado la plataforma: $selected",
                        Toast.LENGTH_LONG
                    )
                        .show()
                }else {
                    Toast.makeText(context, "No has seleccionado nada", Toast.LENGTH_LONG)
                        .show()
                }},
            label = { Text(text = "PS4") },
            leadingIcon = if (selected == "PS4"){
                {
                    Icon(imageVector = Icons.Filled.Check, contentDescription = "Check")
                }
            }else{
                null
            }
        )
        Spacer(modifier = Modifier.width(15.dp))
        FilterChip(selected = selected == "XBOX",
            onClick = { selected = "XBOX"
                if (selected.isNotEmpty()) {
                    Toast.makeText(context,"Has seleccionado la plataforma: $selected",
                        Toast.LENGTH_LONG
                    )
                        .show()
                }else {
                    Toast.makeText(context, "No has seleccionado nada", Toast.LENGTH_LONG)
                        .show()
                }},
            label = { Text(text = "XBOX") },
            leadingIcon = if (selected == "XBOX"){
                {
                    Icon(imageVector = Icons.Filled.Check, contentDescription = "Check")
                }
            }else{
                null
            }
        )
        Spacer(modifier = Modifier.width(15.dp))
        FilterChip(selected = selected == "3DS",
            onClick = { selected = "3DS"
                if (selected.isNotEmpty()) {
                    Toast.makeText(context,"Has seleccionado la plataforma: $selected",
                        Toast.LENGTH_LONG
                    )
                        .show()
                }else {
                    Toast.makeText(context, "No has seleccionado nada", Toast.LENGTH_LONG)
                        .show()
                }},
            label = { Text(text = "3DS") },
            leadingIcon = if (selected == "3DS"){
                {
                    Icon(imageVector = Icons.Filled.Check, contentDescription = "Check")
                }
            }else{
                null
            }
        )
        Spacer(modifier = Modifier.width(15.dp))
        FilterChip(selected = selected == "WII",
            onClick = { selected = "WII"
                if (selected.isNotEmpty()) {
                    Toast.makeText(context,"Has seleccionado la plataforma: $selected",
                        Toast.LENGTH_LONG
                    )
                        .show()
                }else {
                    Toast.makeText(context, "No has seleccionado nada", Toast.LENGTH_LONG)
                        .show()
                }},
            label = { Text(text = "WII") },
            leadingIcon = if (selected == "WII"){
                {
                    Icon(imageVector = Icons.Filled.Check, contentDescription = "Check")
                }
            }else{
                null
            }
        )
        Spacer(modifier = Modifier.width(15.dp))
        FilterChip(selected = selected == "WIIU",
            onClick = { selected = "WIIU"
                if (selected.isNotEmpty()) {
                    Toast.makeText(context,"Has seleccionado la plataforma: $selected",
                        Toast.LENGTH_LONG
                    )
                        .show()
                }else {
                    Toast.makeText(context, "No has seleccionado nada", Toast.LENGTH_LONG)
                        .show()
                }},
            label = { Text(text = "WIIU") },
            leadingIcon = if (selected == "WIIU"){
                {
                    Icon(imageVector = Icons.Filled.Check, contentDescription = "Check")
                }
            }else{
                null
            }
        )

    }

}




