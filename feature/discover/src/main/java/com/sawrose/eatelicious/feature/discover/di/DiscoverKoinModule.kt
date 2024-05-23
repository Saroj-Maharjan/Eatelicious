package com.sawrose.eatelicious.feature.discover.di

import com.sawrose.eatelicious.core.data.di.dataKoinModule
import com.sawrose.eatelicious.core.domain.di.domainKoinModule
import com.sawrose.eatelicious.feature.discover.DiscoverViewmodel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val discoverKoinModule = module {
    includes(dataKoinModule, domainKoinModule)

    viewModelOf(::DiscoverViewmodel)
}
