package com.example.playjuegos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.playjuegos.ui.theme.FontTittle
import com.example.playjuegos.ui.theme.PlayJuegosTheme


@Composable
fun PantallaHorizontal(navController: NavController) {
    PlayJuegosTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        )
        {
            Text(
                text = "Play Juegos",
                fontSize = 40.sp,
                fontFamily = FontTittle
            )

            Spacer(
                modifier = Modifier.size(50.dp),
            )
            Row {
                Button(
                    onClick = { navController.navigate("Play") },
                    modifier = Modifier.width(200.dp).padding(20.dp, 0.dp)
                ) {
                    Text(text = "Play")

                }
                Button(
                    onClick = { navController.navigate("NewPlayer") },
                    modifier = Modifier.width(200.dp).padding(20.dp, 0.dp)
                ) {
                    Text(text = "New Player")


                }
            }
            Row {

                Button(
                    onClick = { navController.navigate("Preferencee") },
                    modifier = Modifier.width(200.dp).padding(20.dp, 0.dp)
                ) {
                    Text(text = "Preferences")
                }

                Button(
                    onClick = { navController.navigate("About") },
                    modifier = Modifier.width(200.dp).padding(20.dp, 0.dp)
                ) {
                    Text(text = "About")
                }

            }
        }
    }
}
