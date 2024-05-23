package com.sawrose.eatelicious.core.data.service

import android.util.Log
import com.sawrose.eatelicious.core.data.repository.RecipeRepository
import com.sawrose.eatelicious.core.data.repository.request.RecipeRequests
import com.sawrose.eatelicious.core.data.repository.service.LocalRecipeService
import com.sawrose.eatelicious.core.data.repository.service.RemoteRecipeService
import com.sawrose.eatelicious.core.model.Recipe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import org.mobilenativefoundation.store.store5.Fetcher
import org.mobilenativefoundation.store.store5.SourceOfTruth
import org.mobilenativefoundation.store.store5.StoreBuilder
import org.mobilenativefoundation.store.store5.StoreReadRequest
import org.mobilenativefoundation.store.store5.StoreReadResponse

class StoreRecipeService(
    private val remoteRecipeService: RemoteRecipeService,
    private val localRecipeService: LocalRecipeService,
) : RecipeRepository {

    private val store = StoreBuilder.from<RecipeRequests, Result<List<Recipe>>, List<Recipe>>(
        fetcher = Fetcher.of { request ->
            remoteRecipeService.fetch(request)
        },
        sourceOfTruth = SourceOfTruth.Companion.of(
            reader = { request ->
                localRecipeService.stream(request)
            },
            writer = { _, recipes ->
                recipes.fold(
                    onSuccess = {
                        localRecipeService.insert(it)
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
