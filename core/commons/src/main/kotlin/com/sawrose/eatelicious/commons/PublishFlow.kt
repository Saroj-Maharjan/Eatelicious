package com.sawrose.eatelicious.commons

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow

fun <E> PublishFlow() = MutableSharedFlow<E>(
    extraBufferCapacity = 1,
    onBufferOverflow = BufferOverflow.SUSPEND,
)