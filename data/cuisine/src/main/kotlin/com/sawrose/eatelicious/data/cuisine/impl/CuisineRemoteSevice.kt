package com.sawrose.eatelicious.data.cuisine.impl

import com.sawrose.eatelicious.core.model.Cuisine
import com.sawrose.eatelicious.core.domain.repository.cuisine.CuisineRemoteService
import com.sawrose.eatelicious.core.domain.repository.cuisine.CuisineRequest
import io.ktor.client.HttpClient

class CuisineRemoteSevice(
    private val client: HttpClient,
) : com.sawrose.eatelicious.core.domain.repository.cuisine.CuisineRemoteService {
    override suspend fun fetch(request: com.sawrose.eatelicious.core.domain.repository.cuisine.CuisineRequest): Result<List<Cuisine>> {
        when (request) {
            is com.sawrose.eatelicious.core.domain.repository.cuisine.CuisineRequest.Search -> {
//                client.getResponse(url){
//
//                }
                return Result.success(listOf())
            }
        }
    }
}