package com.sawrose.eatelicious.core.data.service.remote

import com.sawrose.eatelicious.commons.network.SponcularEndpoints
import com.sawrose.eatelicious.core.data.remote.BaseKtorClient
import com.sawrose.eatelicious.core.data.remote.RemoteParams
import com.sawrose.eatelicious.core.domain.request.RecipeRequests
import com.sawrose.eatelicious.core.domain.service.RemoteRecipeService
import com.sawrose.eatelicious.core.model.Recipe

/** Implementation of [RemoteRecipeServics] */
class SponcularRemoteService(private val apiClient: BaseKtorClient) : RemoteRecipeService {
  override suspend fun fetch(request: RecipeRequests): Result<List<Recipe>> {
    return when (request) {
      is RecipeRequests.random -> {
        apiClient.getResponse(
            endpoint =
                SponcularEndpoints.getRandomRecipe(
                    apikey = apiClient.baseUrl,
                    tags = request.tags,
                    number = request.number,
                ),
            params = getParams(request)
        )
      }
        is RecipeRequests.search -> {
            apiClient.getResponse(
                endpoint = SponcularEndpoints.search(
                    apikey = apiClient.baseUrl,
                    query = "",
                    cuisine = null,
                    addRecipeInformation = false,
                    number = 10,
                    offset = 1,
                    ),
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

    companion object{
        private const val TAGS = "tags"
        private const val NUMBER = "number"
        private const val QUERY = "query"
        private const val CUISINE = "cuisine"
        private const val ADDRECIPEINFORMATION = "addRecipeInfo"
        private const val OFFSET = "number"

    }
}
