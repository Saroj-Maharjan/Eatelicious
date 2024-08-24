package com.sawrose.eatelicious.data.recipe.impl

import android.util.Log
import com.sawrose.eatelicious.core.domain.repository.recipe.LocalRecipeService
import com.sawrose.eatelicious.core.domain.repository.recipe.RecipeRepository
import com.sawrose.eatelicious.core.domain.repository.recipe.RecipeRequests
import com.sawrose.eatelicious.core.domain.repository.recipe.RemoteRecipeService
import com.sawrose.eatelicious.core.logging.bark
import com.sawrose.eatelicious.core.model.LogLevel
import com.sawrose.eatelicious.core.model.Recipe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import org.mobilenativefoundation.store.store5.Fetcher
import org.mobilenativefoundation.store.store5.SourceOfTruth
import org.mobilenativefoundation.store.store5.StoreBuilder
import org.mobilenativefoundation.store.store5.StoreReadRequest
import org.mobilenativefoundation.store.store5.StoreReadResponse

class RecipeStoreService(
    private val remoteService: RemoteRecipeService,
    private val localService: LocalRecipeService,
) : RecipeRepository {

    private val store = StoreBuilder.from<RecipeRequests, Result<List<Recipe>>, List<Recipe>>(
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
                        bark { "Inserting the database: $it" }
                    },
                    onFailure = {
                        bark(LogLevel.Error, throwable = it) {
                            "Error writing data to local source of truth"
                        }
                    },
                )
            },
        ),
    ).build()

    override fun stream(
        request: RecipeRequests,
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
