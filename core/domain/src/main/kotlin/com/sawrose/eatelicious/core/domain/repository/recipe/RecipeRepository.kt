package com.sawrose.eatelicious.core.domain.repository.recipe

import com.sawrose.eatelicious.core.data.Repository
import com.sawrose.eatelicious.core.model.Recipe

interface RecipeRepository : Repository<RecipeRequests, List<Recipe>>
