package com.lasalleaytana.contact_list.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.lasalleaytana.contact_list.ui.ListaContactosScreen
import com.lasalleaytana.contact_list.ui.theme.Contact_ListTheme
import com.lasalleaytana.contact_list.utils.SampleData

// IA generated: Main activity that displays the contact list
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Contact_ListTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // IA generated: Calling the screen with sample data and a simple Toast on click
                    ListaContactosScreen(
                        contactos = SampleData.listaContactos,
                        onContactoClick = { contacto ->
                            Toast.makeText(this, "Click en: ${contacto.nombre}", Toast.LENGTH_SHORT).show()
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
