package com.sawrose.eatelicious.core.data.repository.api

import kotlinx.coroutines.flow.Flow

/**
 * Interface defining functions to insert a data
 * */
interface LocalDataService<Request, Data> {
    /**
     * Insert the supplied [data] to our local datasource
     * */
    suspend fun insert(data: Data)

    /**
     * Stream a flow of [Data] for given [Request]
     * */
    fun stream(request: Request): Flow<Data>
}