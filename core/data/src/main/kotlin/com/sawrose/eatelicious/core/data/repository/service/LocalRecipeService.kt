package com.sawrose.eatelicious.core.data.repository.service

import com.sawrose.eatelicious.core.data.repository.api.LocalDataService
import com.sawrose.eatelicious.core.data.repository.request.RecipeRequests
import com.sawrose.eatelicious.core.model.Recipe

/**
 * Represent local source of truth
 * */
interface LocalRecipeService : LocalDataService<RecipeRequests, List<Recipe>>
