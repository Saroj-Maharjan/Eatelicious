package com.sawrose.eatelicious.core.domain.repository.recipe

import com.sawrose.eatelicious.core.data.LocalDataService
import com.sawrose.eatelicious.core.model.Recipe

interface LocalRecipeService : LocalDataService<RecipeRequests, List<Recipe>> {
}