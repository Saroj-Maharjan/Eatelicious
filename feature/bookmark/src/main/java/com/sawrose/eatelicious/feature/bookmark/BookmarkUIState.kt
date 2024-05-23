package com.sawrose.eatelicious.feature.bookmark

import androidx.compose.runtime.Stable
import com.sawrose.eatelicious.core.model.Recipe
import com.slack.circuit.runtime.CircuitUiState

@Stable
data class BookmarkUIState(
    val recipes: List<Recipe> = emptyList(),
    val eventSink: (BookmarkUIEvent) -> Unit,
) : CircuitUiState

sealed class BookmarkUIEvent {
    data class RecipeClicked(val recipe: Recipe) : BookmarkUIEvent()
}
