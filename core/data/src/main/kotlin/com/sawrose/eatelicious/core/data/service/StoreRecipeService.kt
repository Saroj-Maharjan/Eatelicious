package com.sawrose.eatelicious.core.data.service

import com.sawrose.eatelicious.core.domain.repository.RecipeRepository
import com.sawrose.eatelicious.core.domain.request.RecipeRequests
import com.sawrose.eatelicious.core.domain.service.LocalRecipeService
import com.sawrose.eatelicious.core.domain.service.RemoteRecipeService
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
): RecipeRepository {

    private val store = StoreBuilder.from<RecipeRequests, Result<List<Recipe>>, List<Recipe>>(
        fetcher = Fetcher.of { request ->
            remoteRecipeService.fetch(request)
        },
        sourceOfTruth = SourceOfTruth.Companion.of(
            reader = { request ->
                localRecipeService.stream(request)
            },
            writer = { _, recipes ->
                val recipe = recipes.getOrNull().orEmpty()
                localRecipeService.insert(recipe)
            },
        )
    ).build()

    override fun stream(
        request: RecipeRequests,
        refreshCache: Boolean): Flow<List<Recipe>> {
        return store.stream(
            request = StoreReadRequest.cached(
                key = request,
                refresh = refreshCache
            )
        )
            .distinctUntilChanged()
            .map { response ->
                when(response) {
                    is StoreReadResponse.Data -> {
                        response.value
                    }
                    is StoreReadResponse.NoNewData -> {
                        emptyList()
                    }
                    is StoreReadResponse.Error.Exception,
                    is StoreReadResponse.Error.Message, -> {
                        emptyList()
                    }
                    is StoreReadResponse.Loading -> {
                        emptyList()
                    }
                }
            }
    }
}