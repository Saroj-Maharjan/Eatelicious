package com.sawrose.eatelicious.feature.discover

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sawrose.eatelicious.core.designsystem.component.ScreenBackground
import com.sawrose.eatelicious.core.model.Recipe

@Composable
internal fun DiscoverRoute(
    uiState: DiscoverUIState,
    onRecipeClicked: (Recipe) -> Unit,
    handleEvent: (DiscoverEvent) -> Unit,
) {
    when (uiState) {
        is DiscoverUIState.Loading -> {
            CircularProgressIndicator()
        }

        is DiscoverUIState.Error -> {
            Text("Error: ${uiState.message}")
        }

        is DiscoverUIState.Success -> {
            DiscoverScreen(
                recipes = uiState.data,
                onRecipeClicked = onRecipeClicked,
                handleEvent = handleEvent,
            )
        }
    }
}

@Composable
fun DiscoverScreen(
    recipes: List<Recipe>,
    onRecipeClicked: (Recipe) -> Unit,
    handleEvent: (DiscoverEvent) -> Unit,
) {
    ScreenBackground(
        modifier = Modifier.fillMaxSize(),
    ) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(150.dp),
            contentPadding = PaddingValues(8.dp),
        ) {
            items(recipes) { recipe ->
                DiscoverRow(
                    recipe = recipe,
                    onRecipeClicked = onRecipeClicked,
                    handleEvent = handleEvent,
                )
            }
        }
    }
}
