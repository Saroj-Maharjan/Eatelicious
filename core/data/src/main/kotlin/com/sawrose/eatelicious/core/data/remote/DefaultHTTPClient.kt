package com.sawrose.eatelicious.core.data.remote

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.KotlinxSerializationConverter
import kotlinx.serialization.json.Json

fun defaultHttpClient(
    engine: HttpClientEngine = provideHttpClientEngine(),
) = HttpClient(engine) {
    expectSuccess = true

    install(ContentNegotiation) {
        val converter = KotlinxSerializationConverter(
            Json {
                ignoreUnknownKeys = true
            },
        )
        register(ContentType.Any, converter = converter)
    }

    install(Logging) {
        logger =
            object : Logger {
                override fun log(message: String) {
                    Log.d("Remote service Logs", "Response: $message")
                }
            }
        level = LogLevel.ALL
    }
}
