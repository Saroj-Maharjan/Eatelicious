package com.sawrose.eatelicious.feature.bookmark

import androidx.compose.runtime.Composable
import com.slack.circuit.runtime.presenter.Presenter

class BookmarkPresenter: Presenter<BookmarkUIState> {

    @Composable
    override fun present(): BookmarkUIState {
        return BookmarkUIState(
            recipes = emptyList(),
        ){ event -> {
            when(event){
                is BookmarkUIEvent.RecipeClicked -> {}
            }
        }}
    }
}