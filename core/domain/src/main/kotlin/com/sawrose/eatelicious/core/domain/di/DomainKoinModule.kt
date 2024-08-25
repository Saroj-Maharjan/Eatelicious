package com.sawrose.eatelicious.core.domain.di

import com.sawrose.eatelicious.core.data.di.dataKoinModule
import com.sawrose.eatelicious.core.domain.usecase.GetCuisineUsecase
import com.sawrose.eatelicious.core.domain.usecase.GetRecipeUsecase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainKoinModule = module {
    includes(dataKoinModule)

    factoryOf(::GetRecipeUsecase)
    factoryOf(::GetCuisineUsecase)
}
