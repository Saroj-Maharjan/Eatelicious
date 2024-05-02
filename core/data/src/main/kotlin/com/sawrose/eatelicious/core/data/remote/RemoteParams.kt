package com.sawrose.eatelicious.core.data.remote

import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.parameter

/**
 * Whenever we want to add params to a request, we just return a map of param
 * keys and values. The [BaseKTORClient] can map this to the request builder.
 */
typealias RemoteParams = Map<String, Any>

/**
 * Add All the [params] to this [HttpRequestBuilder] as long as they're not null.
 */
fun HttpRequestBuilder.addParams(params: RemoteParams){
    params.forEach {(key, value) ->
        this.parameter(key, value)
    }
}