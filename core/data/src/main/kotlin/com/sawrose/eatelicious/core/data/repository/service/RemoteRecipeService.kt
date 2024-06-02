package com.sawrose.eatelicious.core.data.repository.service

import com.sawrose.eatelicious.core.data.repository.api.RemoteDataService
import com.sawrose.eatelicious.core.data.remote.dto.RecipeDTO
import com.sawrose.eatelicious.core.data.repository.request.RecipeRequests
import com.sawrose.eatelicious.core.model.Recipe

interface RemoteRecipeService : RemoteDataService<RecipeRequests, List<Recipe>>
