package com.example.illan_oswaldo.Composables


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ContadorCafe() {

    var contador by rememberSaveable { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val textoCafe = if (contador == 1) "café" else "cafés"

        Text(
            text = "Llevas $contador $textoCafe",
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row {


            Spacer(modifier = Modifier.width(12.dp))


            Button(onClick = { contador++ }) {
                Text(text = "Tomar otro café ☕")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ContadorCafePreview() {
    ContadorCafe()
}