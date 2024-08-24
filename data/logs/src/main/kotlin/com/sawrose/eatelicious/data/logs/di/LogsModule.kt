package com.sawrose.eatelicious.data.logs.di

import com.sawrose.eatelicious.core.domain.repository.logs.LogsRepository
import com.sawrose.eatelicious.data.logs.LogsRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val logsModule = module {
    singleOf(::LogsRepositoryImpl) bind LogsRepository::class
}