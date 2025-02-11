package com.sawrose.eatelicious.feature.bookmark

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class BookmarkViewmodel : ViewModel() {

    val uiState = flowOf(listOf("Recipe 1", "Recipe 2", "Recipe 3", "Recipe 4", "Recipe 5")).map {
        BookmarkUIState.Success(it)
    }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000L),
            BookmarkUIState.Loading,
        )
}

sealed interface BookmarkUIState {
    data object Loading : BookmarkUIState
    data class Success(val bookmarks: List<String>) : BookmarkUIState
    data class Error(val message: String) : BookmarkUIState
}
