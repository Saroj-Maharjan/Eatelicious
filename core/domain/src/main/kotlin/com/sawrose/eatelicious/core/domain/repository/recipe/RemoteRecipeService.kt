package com.sawrose.eatelicious.core.domain.repository.recipe

import com.sawrose.eatelicious.core.data.RemoteDataService
import com.sawrose.eatelicious.core.model.Recipe

interface RemoteRecipeService : RemoteDataService<RecipeRequests, List<Recipe>>
