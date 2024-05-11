package com.sawrose.eatelicious.di

import com.sawrose.eatelicious.commons.commonModule
import com.sawrose.eatelicious.core.data.di.dataKoinModule
import com.sawrose.eatelicious.core.domain.di.domainKoinModule
import com.sawrose.eatelicious.feature.discover.di.discoverKoinModule
import org.koin.dsl.module

val eateliciousAppModule = module {
    includes(
        commonModule,
        domainKoinModule,
        dataKoinModule,
        discoverKoinModule
    )
}