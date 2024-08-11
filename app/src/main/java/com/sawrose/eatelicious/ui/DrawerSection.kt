package com.sawrose.eatelicious.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun DrawerSection(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.aspectRatio(2.2f),
        verticalAlignment = Alignment.Bottom,
    ) {
        Column {
            Text("Eatelicious")
        }

    }
}