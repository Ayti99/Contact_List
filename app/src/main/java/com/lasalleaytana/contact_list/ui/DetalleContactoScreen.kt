package com.lasalleaytana.contact_list.ui

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.core.content.ContextCompat

// IA generated: Screen to display the details of a selected contact and allow calling them
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalleContactoScreen(
    nombre: String,
    telefono: String,
    fotoRes: Int,
    onBackClick: () -> Unit
) {
    // IA generated: Get the local context
    val context = LocalContext.current

    // IA generated: Launcher for requesting the CALL_PHONE permission
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            // IA generated: If permission granted in callback, launch the direct call intent
            val intent = Intent(Intent.ACTION_CALL).apply {
                data = Uri.parse("tel:$telefono")
            }
            context.startActivity(intent)
        } else {
            // IA generated: If permission denied, show a Toast to the user
            Toast.makeText(context, "El permiso de llamada es necesario para esta acción", Toast.LENGTH_SHORT).show()
        }
    }

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
            // IA generated: Display contact image
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

            // IA generated: Original button to open the dialer (no permission required)
            Button(
                onClick = {
                    val intent = Intent(Intent.ACTION_DIAL).apply {
                        data = Uri.parse("tel:$telefono")
                    }
                    context.startActivity(intent)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Abrir Marcador")
            }

            Spacer(modifier = Modifier.height(8.dp))

            // IA generated: New button for direct calling (requires CALL_PHONE permission)
            Button(
                onClick = {
                    // IA generated: Check if permission is already granted
                    when (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE)) {
                        PackageManager.PERMISSION_GRANTED -> {
                            // IA generated: Permission already granted, launch direct call
                            val intent = Intent(Intent.ACTION_CALL).apply {
                                data = Uri.parse("tel:$telefono")
                            }
                            context.startActivity(intent)
                        }
                        else -> {
                            // IA generated: Permission not granted, request it
                            permissionLauncher.launch(Manifest.permission.CALL_PHONE)
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
            ) {
                Text(text = "Llamada Directa")
            }
        }
    }
}
