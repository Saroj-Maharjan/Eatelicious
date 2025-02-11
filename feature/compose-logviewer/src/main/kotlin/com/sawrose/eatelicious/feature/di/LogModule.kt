package com.sawrose.eatelicious.feature.di

import com.sawrose.eatelicious.feature.LogFileViewmodel
import com.sawrose.eatelicious.feature.parser.DefaultLogParser
import com.sawrose.eatelicious.feature.parser.LogParser
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val logModule = module {

    singleOf(::DefaultLogParser) bind LogParser::class
    viewModelOf(::LogFileViewmodel)
}
