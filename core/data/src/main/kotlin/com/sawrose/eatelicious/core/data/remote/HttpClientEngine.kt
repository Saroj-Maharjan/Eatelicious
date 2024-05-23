package com.sawrose.eatelicious.core.data.remote

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.cio.CIO

/**
 * Provide an [HttpClientEngine] for a given platform.
 */
fun provideHttpClientEngine(): HttpClientEngine {
    return CIO.create()
}
