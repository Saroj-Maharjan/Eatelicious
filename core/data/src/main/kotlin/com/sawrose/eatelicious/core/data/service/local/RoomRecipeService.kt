package com.sawrose.eatelicious.core.data.service.local

import androidx.room.withTransaction
import com.sawrose.eatelicious.core.data.local.AppDatabase
import com.sawrose.eatelicious.core.data.local.mapper.RecipeMapper
import com.sawrose.eatelicious.core.domain.request.RecipeRequests
import com.sawrose.eatelicious.core.domain.service.LocalRecipeService
import com.sawrose.eatelicious.core.model.Recipe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flowOf

class RoomRecipeService(
    val database: AppDatabase,
    val mapper: RecipeMapper
) : LocalRecipeService {
  override suspend fun insert(data: List<Recipe>) {
    database.withTransaction { data.forEach { recipe ->
        database.recipeTable.saveRecipe(mapper.mapToEntity(recipe)) }
    }
  }

  override fun stream(request: RecipeRequests): Flow<List<Recipe>> {
    when(request){
        is RecipeRequests.search -> {

        }

        is RecipeRequests.random -> {

        }
    }

      return flowOf()
  }
}
