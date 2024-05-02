package com.sawrose.eatelicious.core.domain.service

import com.sawrose.eatelicious.commons.data.RemoteDataService
import com.sawrose.eatelicious.core.domain.request.RecipeRequests
import com.sawrose.eatelicious.core.model.Recipe

interface RemoteRecipeService: RemoteDataService<RecipeRequests, List<Recipe>>