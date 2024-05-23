package com.sawrose.eatelicious.commons

import com.sawrose.eatelicious.commons.dispatcher.DispatcherProvider
import com.sawrose.eatelicious.commons.dispatcher.StandardDispatcherProvider
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val commonModule = module {
    singleOf(::StandardDispatcherProvider) {
        bind<DispatcherProvider>()
    }
}
