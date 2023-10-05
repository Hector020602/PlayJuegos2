package com.example.playjuegos

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.playjuegos.ui.theme.NaranjaFuerte
import java.nio.file.WatchEvent

@SuppressLint("UnrememberedMutableState")
@Composable

fun menuPlay() {
    var estadoCheck1 by rememberSaveable { mutableStateOf(false) }
    var estadoCheck2 by rememberSaveable { mutableStateOf(false) }
    var estadoCheck3 by rememberSaveable { mutableStateOf(false) }
    var estadoCheck4 by rememberSaveable { mutableStateOf(false) }
    var estadoCheck5 by rememberSaveable { mutableStateOf(false) }
    var estadoCheck6 by rememberSaveable { mutableStateOf(false) }
    var estadoCheck7 by rememberSaveable { mutableStateOf(false) }
    var context = LocalContext.current
    val selectedGames = mutableSetOf<String>()

    Column(Modifier.fillMaxSize()) {
        Row(Modifier.padding(8.dp)) {

            Image(
                painter = painterResource(id = R.drawable.games_angrybirds),
                modifier = Modifier
                    .size(60.dp),
                contentDescription = "Angry Birds",
            )
            Checkbox(checked = estadoCheck1, onCheckedChange = {
                estadoCheck1 = !estadoCheck1
            })
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Angry Birds", modifier = Modifier.padding(top = 12.dp))
        }
        Row(Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.games_dragonfly),
                modifier = Modifier
                    .size(60.dp),
                contentDescription = "Dragon Fly",
            )
            Checkbox(checked = estadoCheck2, onCheckedChange = {
                estadoCheck2 = !estadoCheck2
            })
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Dragon Fly",modifier = Modifier.padding(top = 12.dp))
        }
        Row(Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.games_hillclimbingracing),
                modifier = Modifier
                    .size(60.dp),
                contentDescription = "Hill Climbing Racing",
            )
            Checkbox(checked = estadoCheck3, onCheckedChange = {
                estadoCheck3 = !estadoCheck3
            })
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Hill Climbing Racing",modifier = Modifier.padding(top = 12.dp))
        }
        Row(Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.games_radiantdefense),
                modifier = Modifier
                    .size(60.dp),
                contentDescription = "Radient Defense",
            )
            Checkbox(checked = estadoCheck4, onCheckedChange = {
                estadoCheck4 = !estadoCheck4
            })
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Radient Defense",modifier = Modifier.padding(top = 12.dp))
        }
        Row(Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.games_pocketsoccer),
                modifier = Modifier
                    .size(60.dp),
                contentDescription = "Pocket Soccer",
            )
            Checkbox(checked = estadoCheck5, onCheckedChange = {
                estadoCheck5 = !estadoCheck5
            })
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Pocket Soccer",modifier = Modifier.padding(top = 12.dp))
        }
        Row(Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.games_ninjump),
                modifier = Modifier
                    .size(60.dp),
                contentDescription = "Ninja Jump",
            )
            Checkbox(checked = estadoCheck6, onCheckedChange = {
                estadoCheck6 = !estadoCheck6
            })
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Ninja Jump",modifier = Modifier.padding(top = 12.dp))
        }
        Row(Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.games_aircontrol),
                modifier = Modifier
                    .size(60.dp),
                contentDescription = "Air Control",
            )
            Checkbox(checked = estadoCheck7, onCheckedChange = {
                estadoCheck7 = !estadoCheck7
            })
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Air Control",modifier = Modifier.padding(top = 12.dp))
        }

    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        FloatingActionButton(
            modifier = Modifier.padding(16.dp),
            onClick = {
                if (estadoCheck1) selectedGames.add("Angry Birds") else selectedGames.remove("Angry Birds")
                if (estadoCheck2) selectedGames.add("Dragon Fly") else selectedGames.remove("Dragon Fly")
                if (estadoCheck3) selectedGames.add("Hill Climbing Racing") else selectedGames.remove("Hill Climbing Racing")
                if (estadoCheck4) selectedGames.add("Radiant Defense") else selectedGames.remove("Radiant Defense")
                if (estadoCheck5) selectedGames.add("Pocket Soccer") else selectedGames.remove("Pocket Soccer")
                if (estadoCheck6) selectedGames.add("Ninja Jump") else selectedGames.remove("Ninja Jump")
                if (estadoCheck7) selectedGames.add("Air Control") else selectedGames.remove("Air Control")
                if (selectedGames.isNotEmpty()){
                    var gamesText = "Has seleccionado los juegos: "
                    for (string:String in selectedGames){
                        if (string == selectedGames.last()){
                            gamesText += "$string, "
                        }
                        gamesText += "$string "
                    }
                    Toast.makeText(context, gamesText, Toast.LENGTH_LONG).show()
                } else{
                    Toast.makeText(context, "No has seleccionado nada", Toast.LENGTH_LONG).show()
                }
            }, shape = RoundedCornerShape(50.dp), containerColor = NaranjaFuerte
        ) {
            Icon(imageVector = Icons.Filled.Check, contentDescription = "Check", tint = Color.Black, modifier = Modifier)

        }
    }
}








