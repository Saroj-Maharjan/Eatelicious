package com.sawrose.eatelicious.commons.dispatcher

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {
    val ui: CoroutineDispatcher
    val io: CoroutineDispatcher
    val default: CoroutineDispatcher
}
