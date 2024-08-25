package com.sawrose.eatelicious.feature.discover

import android.util.Log
import androidx.activity.compose.ReportDrawnWhen
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sawrose.eatelicious.core.designsystem.component.ScreenBackground
import com.sawrose.eatelicious.core.model.Recipe

@Composable
internal fun DiscoverRoute(
    uiState: DiscoverUIState,
    onShowSnackbar: suspend (String, String?) -> Boolean,
    onRecipeClicked: (Recipe) -> Unit,
    handleEvent: (DiscoverEvent) -> Unit,
) {
    ReportDrawnWhen { uiState !is DiscoverUIState.Loading }
    when (uiState) {
        is DiscoverUIState.Loading -> {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }

        is DiscoverUIState.Error -> {
            Text("Error: ${uiState.message}")
        }

        is DiscoverUIState.Success -> {
            Log.d(
                "DiscoverRoute",
                "DiscoverUIState.Success: ${uiState.randomRecipe.size} | ${uiState.cuisineList.size}",
            )
            AnimatedVisibility(
                visible = uiState.randomRecipe.isNotEmpty(),
                enter = EnterTransition.None,
                exit = fadeOut(),
            ) {
                DiscoverScreen(
                    recipes = uiState.randomRecipe,
                    onShowSnackbar = onShowSnackbar,
                    onRecipeClicked = onRecipeClicked,
                    handleEvent = handleEvent,
                )
            }
        }
    }
}

@Composable
fun DiscoverScreen(
    recipes: List<Recipe>,
    onShowSnackbar: suspend (String, String?) -> Boolean,
    onRecipeClicked: (Recipe) -> Unit,
    handleEvent: (DiscoverEvent) -> Unit,
) {
    ScreenBackground(
        modifier = Modifier.fillMaxSize(),
    ) {
        LazyColumn(
            modifier = Modifier
                .statusBarsPadding()
                .padding(start = 8.dp, end = 8.dp),
        ) {
            item { HomeIngredient(emptyList(), {}, {}) }
            item { Spacer(modifier = Modifier.padding(16.dp)) }
            item { HeaderTitle() }
            item {
                DailyInspiration(
                    recipes = recipes,
                    onShowSnackbar,
                    onRecipeClicked,
                    handleEvent = handleEvent,
                )
            }
            item { Spacer(modifier = Modifier.padding(16.dp)) }
        }
    }
}

@Composable
fun HeaderTitle() {
    Text(
        text = stringResource(id = R.string.Daily_inspiration),
        style = MaterialTheme.typography.titleMedium,
        textAlign = TextAlign.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                top = 16.dp,
                end = 16.dp,
                bottom = 8.dp,
            ),
    )
}

@Composable
fun DailyInspiration(
    recipes: List<Recipe>,
    onShowSnackbar: suspend (String, String?) -> Boolean,
    onRecipeClicked: (Recipe) -> Unit,
    handleEvent: (DiscoverEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(
            8.dp,
            8.dp,
            16.dp,
        ),
    ) {
        items(recipes, key = { it.id }) { recipe ->
            DiscoverCardResources(
                recipe = recipe,
                onShowSnackbar = onShowSnackbar,
                onRecipeClicked = onRecipeClicked,
                handleEvent = handleEvent,
            )
        }
    }
}
