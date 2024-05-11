package com.sawrose.eatelicious.core.data.service.local

import android.util.Log
import com.sawrose.eatelicious.core.data.local.AppDatabase
import com.sawrose.eatelicious.core.data.local.entities.mapToEntity
import com.sawrose.eatelicious.core.data.local.entities.mapToRecipe
import com.sawrose.eatelicious.core.data.local.mapper.RecipeMapper
import com.sawrose.eatelicious.core.data.repository.request.RecipeRequests
import com.sawrose.eatelicious.core.data.repository.service.LocalRecipeService
import com.sawrose.eatelicious.core.model.Recipe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class RoomRecipeService(
    private val database: AppDatabase,
    private val mapper: RecipeMapper
) : LocalRecipeService {
    override suspend fun insert(data: List<Recipe>) {
        data.forEach { recipe ->
            Log.i("Database Op", "insert: $recipe")
            database.recipeTable.saveRecipe(mapper.mapToEntity(recipe))
        }
    }

    override fun stream(request: RecipeRequests): Flow<List<Recipe>> {
        return when (request) {
            is RecipeRequests.search -> {
                flowOf()
            }

            is RecipeRequests.random -> {
                database.recipeTable.getRecipes().map {
                    mapper.mapFromEntityList(it)
                }
            }
        }
    }
}
