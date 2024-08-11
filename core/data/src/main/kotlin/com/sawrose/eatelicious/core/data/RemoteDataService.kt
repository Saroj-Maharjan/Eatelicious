package com.sawrose.eatelicious.core.data

/**
 * Defines the data layer for requesting information
 * from a remote service.
 */
interface RemoteDataService<Request, Data> {
    /**
     * Make an asynchronous request of [Data]
     * */
    suspend fun fetch(request: Request): Result<Data>
}
