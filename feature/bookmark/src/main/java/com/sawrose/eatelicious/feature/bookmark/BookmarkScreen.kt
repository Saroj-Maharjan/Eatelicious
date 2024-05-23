package com.sawrose.eatelicious.feature.bookmark

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
import com.sawrose.eatelicious.commons.di.CircuitInject
import com.sawrose.eatelicious.commons.navigation.BookmarkScreen
import com.sawrose.eatelicious.commons.navigation.DiscoverScreen
import com.sawrose.eatelicious.core.designsystem.component.ScreenBackground
import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.screen.Screen
import com.slack.circuit.runtime.ui.Ui
import com.slack.circuit.runtime.ui.ui

class BookmarkUIFactory: Ui.Factory {
    override fun create(screen: Screen, context: CircuitContext): Ui<*>? = when(screen){
        is BookmarkScreen -> {
            ui<BookmarkUIState> { state, modifier ->
                BookmarkScreen(state, modifier)
            }
        }
        else -> null
    }
}
@Composable
fun BookmarkScreen(
    state: BookmarkUIState,
    modifier: Modifier = Modifier,
) {

  ScreenBackground(modifier = Modifier.fillMaxSize()) {
    Box(modifier = Modifier.fillMaxSize().padding(16.dp).background(color = Color(0x8000838F))) {
      Text(
          text = "Bookmark",
          textAlign = TextAlign.Center,
          modifier = Modifier.padding(16.dp).align(Alignment.Center),
          style = MaterialTheme.typography.bodyLarge)
    }
  }
}
