package com.sawrose.eatelicious.core.data.service.remote

import android.util.Log
import com.sawrose.eatelicious.commons.network.SponcularEndpoints
import com.sawrose.eatelicious.core.data.local.mapper.RecipeMapper
import com.sawrose.eatelicious.core.data.remote.dto.RecipeDTO
import com.sawrose.eatelicious.core.data.remote.dto.Response
import com.sawrose.eatelicious.core.data.remote.dto.toRecipe
import com.sawrose.eatelicious.core.data.remote.BaseKtorClient
import com.sawrose.eatelicious.core.data.remote.RemoteParams
import com.sawrose.eatelicious.core.data.remote.mapper.RecipeDtoMapper
import com.sawrose.eatelicious.core.data.repository.request.RecipeRequests
import com.sawrose.eatelicious.core.data.repository.service.RemoteRecipeService
import com.sawrose.eatelicious.core.model.Recipe

/**
 *  Implementation of [RemoteRecipeService] that fetches data from the Spoonacular API.
 *  */
class SponcularRemoteService(
    private val apiClient: BaseKtorClient,
    private val mapper: RecipeDtoMapper
) : RemoteRecipeService {

    override suspend fun fetch(request: RecipeRequests): Result<List<Recipe>> {
        return when (request) {
            is RecipeRequests.random -> {
                apiClient.getResponse<Response>(
                    endpoint =
                    SponcularEndpoints.getRandomRecipe(),
                    params = getParams(request)
                ).map { response ->
                    Log.i("APIResponse", "fetch: $response")
                    mapper.mapFromEntityList(response.recipes)
                }
            }

            is RecipeRequests.search -> {
                apiClient.getResponse(
                    endpoint = SponcularEndpoints.search(),
                    params = getParams(request)
                )
            }
        }
    }

    private fun getParams(
        request: RecipeRequests,
    ): RemoteParams {
        val initialParams = when (request) {
            is RecipeRequests.random -> {
                mapOf(
                    TAGS to request.tags,
                    NUMBER to request.number
                )
            }

            is RecipeRequests.search -> {
                mapOf(
                    QUERY to request.query,
                    CUISINE to request.cuisine,
                    ADDRECIPEINFORMATION to request.addIngredient,
                    NUMBER to request.number,
                    OFFSET to request.offset
                )
            }
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

    }
}
