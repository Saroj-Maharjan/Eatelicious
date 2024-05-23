package com.sawrose.eatelicious.core.data.repository

import com.sawrose.eatelicious.core.data.repository.api.Repository
import com.sawrose.eatelicious.core.data.repository.request.RecipeRequests
import com.sawrose.eatelicious.core.model.Recipe

interface RecipeRepository : Repository<RecipeRequests, List<Recipe>>
