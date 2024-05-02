package com.sawrose.eatelicious.core.domain.repository

import com.sawrose.eatelicious.commons.data.Repository
import com.sawrose.eatelicious.core.domain.request.RecipeRequests
import com.sawrose.eatelicious.core.model.Recipe

interface RecipeRepository: Repository<RecipeRequests, List<Recipe>>