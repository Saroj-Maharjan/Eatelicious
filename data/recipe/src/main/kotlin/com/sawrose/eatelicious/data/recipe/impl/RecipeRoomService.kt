package com.sawrose.eatelicious.data.recipe.impl

import android.util.Log
import com.sawrose.eatelicious.core.data.local.dao.RecipeDao
import com.sawrose.eatelicious.core.data.local.mapper.RecipeEntityMapper
import com.sawrose.eatelicious.core.model.Recipe
import com.sawrose.eatelicious.core.domain.repository.recipe.LocalRecipeService
import com.sawrose.eatelicious.core.domain.repository.recipe.RecipeRequests
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RecipeRoomService(
    private val recipeTable: RecipeDao,
    private val mapper: RecipeEntityMapper,
) : LocalRecipeService {
    override fun stream(request: RecipeRequests): Flow<List<Recipe>> {
        return when (request) {
//            is RecipeRequests.Search -> {
//                flowOf()
//            }

            is RecipeRequests.Random -> {
                recipeTable.getRecipes().map {
                    mapper.mapFromEntityList(it)
                }
            }

//            is RecipeRequests.RecipeInformation -> {
//                flowOf()
//                database.recipeTable.getRecipe(request.id).map {
//                    listOf(mapper.mapFromEntity(it))
//                }
//            }
        }
    }

    override suspend fun insert(data: List<Recipe>) {
        data.forEach { recipe ->
            Log.i("Database Op", "insert: $recipe")
            recipeTable.saveRecipe(mapper.mapToEntity(recipe))
        }
    }
}