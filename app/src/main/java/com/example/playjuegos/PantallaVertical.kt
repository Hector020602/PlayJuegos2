package com.example.playjuegos

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.playjuegos.ui.theme.FontTittle
import com.example.playjuegos.ui.theme.NaranjaDebil
import com.example.playjuegos.ui.theme.NaranjaFuerte
import com.example.playjuegos.ui.theme.PlayJuegosTheme


@Composable
fun PantallaVertical(navController: NavController) {
    PlayJuegosTheme {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Image(
                painter = painterResource(id = R.drawable.mando),
                contentDescription = "Mando",
                modifier = Modifier.requiredSize(150.dp)
            )
            Text(
                text = "Play Juegos",
                fontSize = 40.sp,
                fontFamily = FontTittle
            )

            Spacer(
                modifier = Modifier.size(50.dp),
            )

            Button(
                onClick = { navController.navigate("menuPlay") },
                modifier = Modifier.width(200.dp),
            ) {
                Text(text = "Play")
            }

            Button(
                onClick = { navController.navigate("menuNewPlayer") },
                modifier = Modifier.width(200.dp),
            ) {
                Text(text = "New Player")
            }

            Button(
                onClick = { navController.navigate("menuPreferences") },
                modifier = Modifier.width(200.dp),
            ) {
                Text(text = "Preferences")
            }

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.width(200.dp),
            ) {
                Text(text = "About")
            }

        }
    }
}