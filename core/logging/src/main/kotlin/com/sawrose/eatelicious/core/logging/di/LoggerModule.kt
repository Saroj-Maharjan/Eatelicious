package com.sawrose.eatelicious.core.logging.di

import androidx.metrics.performance.JankStats
import com.sawrose.eatelicious.core.logging.Heartwood
import com.sawrose.eatelicious.core.logging.bark
import com.sawrose.eatelicious.core.logging.logging.AndroidBark
import com.sawrose.eatelicious.core.model.LogLevel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val loggerModule = module {
    singleOf(::AndroidBark) bind Heartwood.Bark::class
    single { provideOnFrameListener() }
}

fun provideOnFrameListener(): JankStats.OnFrameListener = JankStats.OnFrameListener { frameData ->
    // Make sure to only log janky frames.
    if (frameData.isJank) {
        bark(priority = LogLevel.Info, tag = "Jank") { frameData.toString() }
    }
}
