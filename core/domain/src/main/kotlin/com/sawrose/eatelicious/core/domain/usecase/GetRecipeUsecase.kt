package com.sawrose.eatelicious.core.domain.usecase

import com.sawrose.eatelicious.core.domain.repository.RecipeRepository
import com.sawrose.eatelicious.core.domain.request.RecipeRequests

class GetRecipeUsecase(
    private val repository: RecipeRepository
) {
    operator fun invoke(request: RecipeRequests) =
        repository.stream(request)
}