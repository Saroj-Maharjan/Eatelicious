package com.sawrose.eatelicious.data.cuisine.impl

import com.sawrose.eatelicious.core.domain.repository.cuisine.CuisineRemoteService
import com.sawrose.eatelicious.core.domain.repository.cuisine.CuisineRequest
import com.sawrose.eatelicious.core.model.Cuisine
import io.ktor.client.HttpClient

class CuisineRemoteSevice(
    private val client: HttpClient,
) : CuisineRemoteService {
    override suspend fun fetch(request: CuisineRequest): Result<List<Cuisine>> {
        when (request) {
            is CuisineRequest.Search -> {
//                client.getResponse(url){
//
//                }
                return Result.success(listOf())
            }
        }
    }
}
