package com.sawrose.eatelicious.core.data.repository.api

import kotlinx.coroutines.flow.Flow

/**
 * Defines the data layer for any data repository
 * */
interface Repository<Request, Data> {

    /**
     * Provide a flow response of data for given [request]
     * */
    fun stream(
        request: Request,
        refreshCache: Boolean = true
    ): Flow<Data>
}