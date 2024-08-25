package com.sawrose.eatelicious.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun DrawerSection(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.aspectRatio(2.2f),
        verticalAlignment = Alignment.Bottom,
    ) {
        Column {
            Text("Eatelicious")
        }
        Button(onClick = { navHostController.navigate("logfile") }) {
            Text("Show Logs")
        }
    }
}
