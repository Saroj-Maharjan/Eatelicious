package com.sawrose.eatelicious.feature.discover

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sawrose.eatelicious.core.designsystem.component.ScreenBackground

@Composable
internal fun DiscoverRoute() {
  DiscoverScreen()
}

@Composable
fun DiscoverScreen() {
  ScreenBackground(
      modifier = Modifier.fillMaxSize()
  ) {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .background(color = Color(0x8000838F))
    ) {
      Text(
          text = "Discover",
          textAlign = TextAlign.Center,
          modifier = Modifier.padding(16.dp).align(Alignment.Center),
          style = MaterialTheme.typography.bodyLarge)
    }
  }
}
