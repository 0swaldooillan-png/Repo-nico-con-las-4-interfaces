package com.example.illan_oswaldo.Composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


data class Persona(
    val nombre: String = "",
    val ciudad: String = "",
    val edad: String = ""
)

@Composable
fun FichaPersonaScreen() {
    var estadoPersona by remember { mutableStateOf(Persona()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Formulario Stateless
        FichaPersonaForm(
            persona = estadoPersona,
            onNombreChange = { nuevoNombre ->
                estadoPersona = estadoPersona.copy(nombre = nuevoNombre)
            },
            onCiudadChange = { nuevaCiudad ->
                estadoPersona = estadoPersona.copy(ciudad = nuevaCiudad)
            },
            onEdadChange = { nuevaEdad ->
                // Filtrar para aceptar únicamente números
                if (nuevaEdad.all { it.isDigit() }) {
                    estadoPersona = estadoPersona.copy(edad = nuevaEdad)
                }
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Vista previa Stateless
        FichaPersonaCard(persona = estadoPersona)
    }
}

// 3. Formulario Stateless
@Composable
fun FichaPersonaForm(
    persona: Persona,
    onNombreChange: (String) -> Unit,
    onCiudadChange: (String) -> Unit,
    onEdadChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Datos Personales",
            style = MaterialTheme.typography.titleLarge
        )

        OutlinedTextField(
            value = persona.nombre,
            onValueChange = onNombreChange,
            label = { Text("Nombre completo") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        OutlinedTextField(
            value = persona.ciudad,
            onValueChange = onCiudadChange,
            label = { Text("Ciudad") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        OutlinedTextField(
            value = persona.edad,
            onValueChange = onEdadChange,
            label = { Text("Edad") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}

// 4. Tarjeta de visualización Stateless
@Composable
fun FichaPersonaCard(
    persona: Persona,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Ficha de Registro",
                style = MaterialTheme.typography.titleMedium
            )
            HorizontalDivider()
            Text(text = "Nombre: ${persona.nombre.ifEmpty { "—" }}")
            Text(text = "Ciudad: ${persona.ciudad.ifEmpty { "—" }}")
            Text(text = "Edad: ${if (persona.edad.isNotEmpty()) "${persona.edad} años" else "—"}")
        }
    }
}

// 5. Previsualización para Android Studio
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FichaPersonaPreview() {
    MaterialTheme {
        FichaPersonaScreen()
    }
}