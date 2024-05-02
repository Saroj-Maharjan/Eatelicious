package com.sawrose.eatelicious.core.domain.service

import com.sawrose.eatelicious.commons.data.LocalDataService
import com.sawrose.eatelicious.core.domain.request.RecipeRequests
import com.sawrose.eatelicious.core.model.Recipe

/**
 * Represent local source of truth
 * */
interface LocalRecipeService : LocalDataService<RecipeRequests, List<Recipe>>