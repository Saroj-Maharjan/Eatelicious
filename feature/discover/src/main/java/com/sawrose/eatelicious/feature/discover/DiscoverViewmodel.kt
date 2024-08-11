package com.sawrose.eatelicious.feature.discover

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sawrose.eatelicious.core.domain.repository.cuisine.CuisineRequest
import com.sawrose.eatelicious.core.domain.repository.recipe.RecipeRequests
import com.sawrose.eatelicious.core.domain.usecase.GetCuisineUsecase
import com.sawrose.eatelicious.core.domain.usecase.GetRecipeUsecase
import com.sawrose.eatelicious.core.model.Cuisine
import com.sawrose.eatelicious.core.model.Recipe
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DiscoverViewmodel(
    private val getRecipeUsecase: GetRecipeUsecase,
    private val getCuisineUsecase: GetCuisineUsecase,
) : ViewModel() {

    private val _discoveruiState: MutableStateFlow<DiscoverUIState> =
        MutableStateFlow(DiscoverUIState.Loading)
    val discoveruiState = _discoveruiState.asStateFlow()

    init {
        getAllReceipes()
    }

    private fun getAllReceipes() {
        viewModelScope.launch {
            getRecipeUsecase(RecipeRequests.Random(10, "breakfast"))
                .combine(
                    getCuisineUsecase(CuisineRequest.Search),
                ) { recipe, cuisine ->
                    _discoveruiState.update {
                        DiscoverUIState.Success(recipe, cuisine)
                    }
                }
//                .onStart {
//                    _discoveruiState.update {
//                        DiscoverUIState.Loading
//                    }
//                }
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

sealed interface DiscoverUIState {
    data object Loading : DiscoverUIState
    data class Success(
        val randomRecipe: List<Recipe>,
        val cuisineList: List<Cuisine>,
    ) : DiscoverUIState

    data class Error(val message: String) : DiscoverUIState
}

sealed class DiscoverEvent {
    data class OnRecipeClicked(val recipe: Recipe) : DiscoverEvent()
}
