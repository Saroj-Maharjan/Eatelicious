package com.sawrose.eatelicious.data.cuisine.impl

import android.util.Log
import com.sawrose.eatelicious.core.domain.repository.cuisine.CuisineRemoteService
import com.sawrose.eatelicious.core.domain.repository.cuisine.CuisineRepository
import com.sawrose.eatelicious.core.domain.repository.cuisine.CuisineRequest
import com.sawrose.eatelicious.core.domain.repository.cuisine.LocalCuisineService
import com.sawrose.eatelicious.core.model.Cuisine
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import org.mobilenativefoundation.store.store5.Fetcher
import org.mobilenativefoundation.store.store5.SourceOfTruth
import org.mobilenativefoundation.store.store5.StoreBuilder
import org.mobilenativefoundation.store.store5.StoreReadRequest
import org.mobilenativefoundation.store.store5.StoreReadResponse

class CuisineStoreService(
    private val remoteService: CuisineRemoteService,
    private val cacheService: LocalCuisineService,
) : CuisineRepository {

    private val store = StoreBuilder.from<CuisineRequest, Result<List<Cuisine>>, List<Cuisine>>(
        fetcher = Fetcher.of { request ->
            remoteService.fetch(request)
        },
        sourceOfTruth = SourceOfTruth.Companion.of(
            reader = { request ->
                cacheService.stream(request)
            },
            writer = { _, recipes ->
                recipes.fold(
                    onSuccess = {
                        cacheService.insert(it)
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
        request: CuisineRequest,
        refreshCache: Boolean,
    ): Flow<List<Cuisine>> {
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
