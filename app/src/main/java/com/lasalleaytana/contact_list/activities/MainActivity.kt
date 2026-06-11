package com.lasalleaytana.contact_list.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.lasalleaytana.contact_list.ui.DetalleContactoScreen
import com.lasalleaytana.contact_list.ui.ListaContactosScreen
import com.lasalleaytana.contact_list.ui.theme.Contact_ListTheme
import com.lasalleaytana.contact_list.utils.SampleData

// IA generated: Main activity that sets up the navigation graph for the application
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Contact_ListTheme {
                AppNavigation()
            }
        }
    }
}

// IA generated: Composable that defines the NavHost and routes for the app navigation
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "lista",
            modifier = Modifier.padding(innerPadding)
        ) {
            // IA generated: Route for the main contact list
            composable("lista") {
                ListaContactosScreen(
                    contactos = SampleData.listaContactos,
                    onContactoClick = { contacto ->
                        // IA generated: Navigation to the detail screen with arguments
                        navController.navigate("detalle/${contacto.nombre}/${contacto.telefono}/${contacto.fotoRes}")
                    }
                )
            }

            // IA generated: Route for the contact detail screen with typed arguments
            composable(
                route = "detalle/{nombre}/{telefono}/{fotoRes}",
                arguments = listOf(
                    navArgument("nombre") { type = NavType.StringType },
                    navArgument("telefono") { type = NavType.StringType },
                    navArgument("fotoRes") { type = NavType.IntType }
                )
            ) { backStackEntry ->
                val nombre = backStackEntry.arguments?.getString("nombre") ?: ""
                val telefono = backStackEntry.arguments?.getString("telefono") ?: ""
                val fotoRes = backStackEntry.arguments?.getInt("fotoRes") ?: 0

                DetalleContactoScreen(
                    nombre = nombre,
                    telefono = telefono,
                    fotoRes = fotoRes,
                    onBackClick = { navController.popBackStack() }
                )
            }
        }
    }
}
