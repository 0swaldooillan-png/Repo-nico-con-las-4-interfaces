package com.example.illan_oswaldo.Composables

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FichaEstudiantePreview() {
    MaterialTheme {
        FichaEstudianteScreen()
    }
}

data class Estudiante(
    val nombre: String = "",
    val matricula: String = "",
    val carrera: String = ""
)


@Composable
fun FichaEstudianteScreen() {
    var estadoEstudiante by remember { mutableStateOf(Estudiante()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        FichaEstudianteForm(
            estudiante = estadoEstudiante,
            onNombreChange = { nuevoNombre ->
                estadoEstudiante = estadoEstudiante.copy(nombre = nuevoNombre)
            },
            onMatriculaChange = { nuevaMatricula ->
                estadoEstudiante = estadoEstudiante.copy(matricula = nuevaMatricula)
            },
            onCarreraChange = { nuevaCarrera ->
                estadoEstudiante = estadoEstudiante.copy(carrera = nuevaCarrera)
            }
        )

        Spacer(modifier = Modifier.height(24.dp))


        FichaEstudianteCard(estudiante = estadoEstudiante)
    }
}


@Composable
fun FichaEstudianteForm(
    estudiante: Estudiante,
    onNombreChange: (String) -> Unit,
    onMatriculaChange: (String) -> Unit,
    onCarreraChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Datos del Estudiante",
            style = MaterialTheme.typography.titleLarge
        )

        OutlinedTextField(
            value = estudiante.nombre,
            onValueChange = onNombreChange,
            label = { Text("Nombre completo") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = estudiante.matricula,
            onValueChange = onMatriculaChange,
            label = { Text("Matrícula / ID") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = estudiante.carrera,
            onValueChange = onCarreraChange,
            label = { Text("Carrera") },
            modifier = Modifier.fillMaxWidth()
        )
    }
}


@Composable
fun FichaEstudianteCard(
    estudiante: Estudiante,
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
                text = "Ficha de Identificación",
                style = MaterialTheme.typography.titleMedium
            )
            HorizontalDivider()
            Text(text = "Nombre: ${estudiante.nombre.ifEmpty { "—" }}")
            Text(text = "Matrícula: ${estudiante.matricula.ifEmpty { "—" }}")
            Text(text = "Carrera: ${estudiante.carrera.ifEmpty { "—" }}")
        }
    }
}