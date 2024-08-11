package com.sawrose.eatelicious.data.recipe.impl

import android.util.Log
import com.sawrose.eatelicious.core.model.Recipe
import com.sawrose.eatelicious.core.domain.repository.recipe.LocalRecipeService
import com.sawrose.eatelicious.core.domain.repository.recipe.RecipeRepository
import com.sawrose.eatelicious.core.domain.repository.recipe.RecipeRequests
import com.sawrose.eatelicious.core.domain.repository.recipe.RemoteRecipeService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import org.mobilenativefoundation.store.store5.Fetcher
import org.mobilenativefoundation.store.store5.SourceOfTruth
import org.mobilenativefoundation.store.store5.StoreBuilder
import org.mobilenativefoundation.store.store5.StoreReadRequest
import org.mobilenativefoundation.store.store5.StoreReadResponse

class RecipeStoreService(
    private val remoteService: com.sawrose.eatelicious.core.domain.repository.recipe.RemoteRecipeService,
    private val localService: com.sawrose.eatelicious.core.domain.repository.recipe.LocalRecipeService,
) : com.sawrose.eatelicious.core.domain.repository.recipe.RecipeRepository {

    private val store = StoreBuilder.from<com.sawrose.eatelicious.core.domain.repository.recipe.RecipeRequests, Result<List<Recipe>>, List<Recipe>>(
        fetcher = Fetcher.of { request ->
            remoteService.fetch(request)
        },
        sourceOfTruth = SourceOfTruth.Companion.of(
            reader = { request ->
                localService.stream(request)
            },
            writer = { _, recipes ->
                recipes.fold(
                    onSuccess = {
                        localService.insert(it)
                        Log.i("StoreRecipeService", "Inserting the database: $it")
                    },
                    onFailure = {
                        Log.e(
                            "StoreRecipeService",
                            "Error writing data to local source of truth",
                            it,
                        )
                    },
                )
            },
        ),
    ).build()

    override fun stream(
        request: com.sawrose.eatelicious.core.domain.repository.recipe.RecipeRequests,
        refreshCache: Boolean,
    ): Flow<List<Recipe>> {
        return store.stream(
            request = StoreReadRequest.cached(
                key = request,
                refresh = refreshCache,
            ),
        )
            .distinctUntilChanged()
            .map { response ->
                when (response) {
                    is StoreReadResponse.Data -> {
                        response.value
                    }

                    is StoreReadResponse.NoNewData -> {
                        emptyList()
                    }

                    is StoreReadResponse.Error.Exception,
                    is StoreReadResponse.Error.Message,
                    -> {
                        emptyList()
                    }

                    is StoreReadResponse.Loading -> {
                        emptyList()
                    }
                }
            }
    }
}
