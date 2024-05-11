package com.sawrose.eatelicious.feature.discover

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sawrose.eatelicious.core.data.repository.request.RecipeRequests
import com.sawrose.eatelicious.core.domain.usecase.GetRecipeUsecase
import com.sawrose.eatelicious.core.model.Recipe
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DiscoverViewmodel(
    private val getRecipeUsecase: GetRecipeUsecase,
) : ViewModel() {

    private val _discoveruiState: MutableStateFlow<DiscoverUIState> =
        MutableStateFlow(DiscoverUIState.Loading)
    val discoveruiState = _discoveruiState.asStateFlow()

    init {
        getReceipes()
    }

    private fun getReceipes() {
        viewModelScope.launch {
            getRecipeUsecase(RecipeRequests.random(10, "breakfast"))
                .collect { recipes ->
                    if(recipes.isEmpty()){
                        _discoveruiState.update {
                            DiscoverUIState.Error("No recipes found")
                        }
                    } else {
                        _discoveruiState.update {
                            DiscoverUIState.Success(recipes)
                        }
                    }
                }
        }
    }

    fun handleEvent(event: DiscoverEvent) {
        when (event) {
            is DiscoverEvent.OnRecipeClicked -> {
                // Handle click event
            }
        }
    }

}

sealed class DiscoverUIState {
    data object Loading : DiscoverUIState()
    data class Success(val data: List<Recipe>) : DiscoverUIState()
    data class Error(val message: String) : DiscoverUIState()
}

sealed class DiscoverEvent {
    data class OnRecipeClicked(val recipe: Recipe) : DiscoverEvent()
}