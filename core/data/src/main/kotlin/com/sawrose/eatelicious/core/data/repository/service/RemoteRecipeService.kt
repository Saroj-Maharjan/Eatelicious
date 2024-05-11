package com.sawrose.eatelicious.core.data.repository.service

import com.sawrose.eatelicious.commons.data.RemoteDataService
import com.sawrose.eatelicious.core.data.remote.dto.RecipeDTO
import com.sawrose.eatelicious.core.data.repository.request.RecipeRequests

interface RemoteRecipeService: RemoteDataService<RecipeRequests, List<RecipeDTO>>