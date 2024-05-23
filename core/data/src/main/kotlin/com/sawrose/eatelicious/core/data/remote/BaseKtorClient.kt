package com.sawrose.eatelicious.core.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

/**
 * Defines the API client information for communicating with the spooncular API.
 */
open class BaseKtorClient(
    val baseUrl: String,
    val httpClient: HttpClient,
) {
    constructor(baseUrl: String) : this(baseUrl, defaultHttpClient())

    /**
     * A helper function to build the [baseUrl] and [endpoint] operation and perform a get request.
     * */

    suspend inline fun <reified T : Any> getResponse(
        endpoint: String,
        params: RemoteParams = emptyMap(),
    ): Result<T> {
        val url = "$baseUrl$endpoint"
        return try {
            val apiResult: T = httpClient.get(url) {
                addParams(params)
            }.body()
            Result.success(apiResult)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
