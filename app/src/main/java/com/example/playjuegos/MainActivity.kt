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
import java.util.prefs.Preferences

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlayJuegosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "MainActivity"){
                        composable("menuPlay") { menuPlay() }
                        composable("menuNewPlayer") { NewPlayer() }
                        composable("menuPreferences") { Preferences() }
                        composable("MainActivity") { MenuPlayJuegos(navController) }
                    }

                }
            }
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun MenuPlayJuegos(navController: NavController) {
    //PlayJuegosTheme {
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
//}