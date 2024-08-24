package com.sawrose.eatelicious.di

import com.sawrose.eatelicious.commons.di.commonModule
import com.sawrose.eatelicious.core.data.di.dataKoinModule
import com.sawrose.eatelicious.core.domain.di.domainKoinModule
import com.sawrose.eatelicious.core.logging.loggerModule
import com.sawrose.eatelicious.data.cuisine.impl.di.cuisineModule
import com.sawrose.eatelicious.data.logs.di.logsModule
import com.sawrose.eatelicious.data.recipe.impl.di.recipeModule
import com.sawrose.eatelicious.feature.bookmark.di.bookmarkKoinModule
import com.sawrose.eatelicious.feature.di.logModule
import com.sawrose.eatelicious.feature.discover.di.discoverKoinModule
import org.koin.dsl.module

val eateliciousAppModule = module {
    includes(
        commonModule,
        domainKoinModule,
        dataKoinModule,
        recipeModule,
        cuisineModule,
        discoverKoinModule,
        bookmarkKoinModule,
        logsModule,
        logModule,
        loggerModule,
    )
}
