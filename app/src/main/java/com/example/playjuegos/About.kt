package com.example.playjuegos

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



data class UserWithImage(val userName: String, val imageResId: Int)
@Composable
fun About() {
    val usersWithImages = listOf(
        UserWithImage("Maria Mata", R.drawable.image1),
        UserWithImage("Ruben Sanz", R.drawable.image2),
        UserWithImage("Carlos Personat", R.drawable.image3),
        UserWithImage("Ana Mena", R.drawable.image4),
        UserWithImage("Jaime Llorente", R.drawable.image5),
        UserWithImage("Andrea Gazulla", R.drawable.image6),
        UserWithImage("Martin Diaz", R.drawable.image7),
        UserWithImage("Carla Lopez", R.drawable.image8),

        )

    var selectedUser by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn {
            items(usersWithImages) { userWithImage ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            selectedUser = userWithImage.userName
                        }
                        .padding(12.dp)
                ) {
                    // Imagen
                    Image(
                        painter = painterResource(id = userWithImage.imageResId),
                        contentDescription = null,
                        modifier = Modifier
                            .size(150.dp)
                    )

                    Spacer(modifier = Modifier.width(20.dp))
                    Text(
                        text = userWithImage.userName,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterVertically)

                    )
                }
            }
        }
    }
}
