package com.sawrose.eatelicious.data.recipe.impl

import android.util.Log
import com.sawrose.eatelicious.core.data.remote.RemoteParams
import com.sawrose.eatelicious.core.data.remote.dto.Response
import com.sawrose.eatelicious.core.data.remote.dto.toRecipe
import com.sawrose.eatelicious.core.data.remote.getResponse
import com.sawrose.eatelicious.core.domain.repository.recipe.RecipeRequests
import com.sawrose.eatelicious.core.domain.repository.recipe.RemoteRecipeService
import com.sawrose.eatelicious.core.model.Recipe
import com.sawrose.eatelicious.data.recipe.BuildConfig
import io.ktor.client.HttpClient

/**
 *  Implementation of [RemoteRecipeService] that fetches data from the Spoonacular API.
 *  */
class RecipeRemoteService(
    private val client: HttpClient,
) : RemoteRecipeService {

    override suspend fun fetch(request: RecipeRequests): Result<List<Recipe>> {
        val apiKey = BuildConfig.SPOONCULAR_API_KEY
        return when (request) {
            is RecipeRequests.Random -> {
                client.getResponse<Response>(
                    endpoint = "/recipes/random?apiKey=$apiKey",
                    params = getParams(request),
                ).map { response ->
                    Log.i("APIResponse", "fetch: $response")
                    response.recipes.map { it.toRecipe() }
                }
            }

//            is RecipeRequests.Search -> {
//                apiClient.getResponse(
//                    endpoint = SponcularEndpoints.search(),
//                    params = getParams(request),
//                )
//            }

//            is RecipeRequests.RecipeInformation -> {
//                apiClient.getResponse(
//                    endpoint = SponcularEndpoints.getRecipe(),
//                    params = getParams(request),
//                )
//            }
        }
    }

    private fun getParams(
        request: RecipeRequests,
    ): RemoteParams {
        val initialParams = when (request) {
            is RecipeRequests.Random -> {
                mapOf(
                    TAGS to request.tags,
                    NUMBER to request.number,
                )
            }

//            is RecipeRequests.Search -> {
//                mapOf(
//                    QUERY to request.query,
//                    CUISINE to request.cuisine,
//                    ADDRECIPEINFORMATION to request.addIngredient,
//                    NUMBER to request.number,
//                    OFFSET to request.offset,
//                )
//            }
//
//            is RecipeRequests.RecipeInformation -> {
//                mapOf(
//                    ID to request.id,
//                    INCLUDENUTRITION to request.includeNutrition,
//                )
//            }
        }

        return initialParams
    }

    companion object {
        private const val TAGS = "tags"
        private const val NUMBER = "number"
        private const val QUERY = "query"
        private const val CUISINE = "cuisine"
        private const val ADDRECIPEINFORMATION = "addRecipeInfo"
        private const val OFFSET = "number"
        private const val ID = "id"
        private const val INCLUDENUTRITION = "includeNutrition"
    }
}
