package com.sawrose.eatelicious.commons.data

import com.sawrose.eatelicious.core.model.Recipe

/**
 * Defines the data layer for requesting information
 * from a remote service.
 */
interface RemoteDataService<Request, Data> {
    /**
     * Make an asynchronous request of [Data]
     * */
    suspend fun fetch(request: Request): Result<List<Recipe>>
}
