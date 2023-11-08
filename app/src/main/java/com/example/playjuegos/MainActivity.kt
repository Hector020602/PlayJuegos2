package com.example.playjuegos

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.playjuegos.ui.theme.PlayJuegosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlayJuegosTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    //Navegacion de los primeros botones
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "MainActivity"){
                        composable("MainActivity") { MenuPlayJuegos(navController) }
                        composable("Play") { Play() }
                        composable("NewPlayer") { NewPlayer() }
                        composable("Preferences") { Preferences() }
                        composable("About") { About() }
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun MenuPlayJuegos(navController: NavController) {
    val configuration = LocalConfiguration.current
    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            PantallaHorizontal(navController)
        }

        else -> {
            PantallaVertical(navController)
        }
    }
}