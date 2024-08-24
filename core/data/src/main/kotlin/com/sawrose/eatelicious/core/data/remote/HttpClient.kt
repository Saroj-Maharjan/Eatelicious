package com.sawrose.eatelicious.core.data.remote

import android.util.Log
import com.sawrose.eatelicious.core.data.remote.exception.ClientUnauthorizedException
import com.sawrose.eatelicious.core.data.remote.exception.HttpNotOkException
import io.ktor.client.HttpClient
import io.ktor.client.call.NoTransformationFoundException
import io.ktor.client.call.body
import io.ktor.client.plugins.Charsets
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.basicAuth
import io.ktor.client.request.bearerAuth
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.http.parameters
import io.ktor.serialization.JsonConvertException
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject

@OptIn(ExperimentalSerializationApi::class)
fun getHttpClient(
    apiStateProvider: ApiStateProvider,
): HttpClient {
    return HttpClient {
        install(Logging) {
            level = LogLevel.ALL
            logger = object : io.ktor.client.plugins.logging.Logger {
                override fun log(message: String) {
                    Log.i("Ktor", message)
                }
            }
        }

        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    explicitNulls = false
                },
            )
        }

        Charsets {
            register(Charsets.UTF_8)
        }

        defaultRequest {
            when (val authorisation = requireNotNull(apiStateProvider.authorisation)) {
                is Authorisation.Basic -> basicAuth(authorisation.username, authorisation.password)
                is Authorisation.ApiKey -> parameters { "apiKey" to authorisation.apiKey }
                is Authorisation.Bearer -> bearerAuth(authorisation.token)
            }
            val baseUrl = requireNotNull(apiStateProvider.serverAddress)
            url(baseUrl)
            contentType(ContentType.Application.Json)
        }

        expectSuccess = true

        HttpResponseValidator {
            handleResponseExceptionWithRequest { cause, _ ->
                throw when (cause) {
                    is ResponseException -> cause.toHttpNotOkException()
                    else -> cause
                }
            }
        }
    }
}

private suspend fun ResponseException.toHttpNotOkException(): HttpNotOkException {
    // Try to extract the error message from TrueNAS
    val message = try {
        response.body<JsonObject>().getValue("message").toString()
    } catch (_: JsonConvertException) {
        message ?: response.status.description
    } catch (_: NoSuchElementException) {
        message ?: response.status.description
    } catch (_: NoTransformationFoundException) {
        message ?: response.status.description
    }
    return when (this) {
        is RedirectResponseException -> {
            com.sawrose.eatelicious.core.data.remote.exception.RedirectResponseException(
                code = response.status.value,
                description = message,
                cause = cause,
            )
        }

        is ClientRequestException -> {
            if (this.response.status == HttpStatusCode.Unauthorized) {
                ClientUnauthorizedException(description = message, cause = cause)
            } else {
                com.sawrose.eatelicious.core.data.remote.exception.ClientRequestException(
                    code = response.status.value,
                    description = message,
                    cause = cause,
                )
            }
        }

        is ServerResponseException -> {
            com.sawrose.eatelicious.core.data.remote.exception.ServerResponseException(
                code = response.status.value,
                description = message,
                cause = cause,
            )
        }

        else -> {
            HttpNotOkException(
                code = response.status.value,
                description = message,
                cause = cause,
            )
        }
    }
}

/**
 * A helper function to build the [baseURL] and [endpoint] operation and performs a get request.
 *
 * Will also pass in the supplied [params] as necessary.
 */
suspend inline fun <reified T : Any> HttpClient.getResponse(
    endpoint: String,
    params: RemoteParams = emptyMap(),
): Result<T> {
    return try {
        Log.d("HttpClient", "getResponse: $endpoint")
        val apiResult: T = get(endpoint) {
            addParams(params)
        }.body()
        Result.success(apiResult)
    } catch (e: Exception) {
        Result.failure(e)
    }
}