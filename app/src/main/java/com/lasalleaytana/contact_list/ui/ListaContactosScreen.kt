package com.lasalleaytana.contact_list.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lasalleaytana.contact_list.models.Contacto

// IA generated: Composable that displays a single contact row with an avatar (initial), name, and phone
@Composable
fun ContactoItem(contacto: Contacto, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // IA generated: Simple avatar using the first letter of the name
        Surface(
            modifier = Modifier.size(48.dp),
            shape = CircleShape,
            color = MaterialTheme.colorScheme.primaryContainer
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = contacto.nombre.take(1).uppercase(),
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = contacto.nombre,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = contacto.telefono,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

// IA generated: Main screen that uses LazyColumn to display the list of contacts
@Composable
fun ListaContactosScreen(
    contactos: List<Contacto>, 
    onContactoClick: (Contacto) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        items(contactos) { contacto ->
            ContactoItem(
                contacto = contacto,
                onClick = { onContactoClick(contacto) }
            )
        }
    }
}
