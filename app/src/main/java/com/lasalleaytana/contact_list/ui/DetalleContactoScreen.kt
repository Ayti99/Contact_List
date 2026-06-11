package com.lasalleaytana.contact_list.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

// IA generated: Screen to display the details of a selected contact and allow calling them
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalleContactoScreen(
    nombre: String,
    telefono: String,
    fotoRes: Int,
    onBackClick: () -> Unit
) {
    // IA generated: Get the local context to start the intent
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalle del Contacto") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        // IA generated: Using AutoMirrored version for better accessibility support
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // IA generated: Display contact image using the resource ID passed as argument
            Image(
                painter = painterResource(id = fotoRes),
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = nombre,
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = telefono,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(32.dp))

            // IA generated: Button to open the dialer with the contact's phone number
            Button(
                onClick = {
                    // IA generated: Create and launch intent to dial the number as per instructions
                    val intent = Intent(Intent.ACTION_DIAL).apply {
                        data = Uri.parse("tel:$telefono")
                    }
                    context.startActivity(intent)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Llamar a $nombre")
            }
        }
    }
}
