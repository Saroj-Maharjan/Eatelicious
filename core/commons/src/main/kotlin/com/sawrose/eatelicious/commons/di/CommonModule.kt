package com.sawrose.eatelicious.commons.di

import android.app.Activity
import android.view.Window
import androidx.metrics.performance.JankStats
import com.sawrose.eatelicious.commons.dispatcher.DispatcherProvider
import com.sawrose.eatelicious.commons.dispatcher.StandardDispatcherProvider
import com.sawrose.eatelicious.core.logging.LogPriority
import com.sawrose.eatelicious.core.logging.bark
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val commonModule = module {
    single { provideOnFrameListener() }
    single { provideWindow(get()) }
    single { provideJankStats(get(), get()) }
    singleOf(::StandardDispatcherProvider) {
        bind<DispatcherProvider>()
    }
}

fun provideOnFrameListener(): JankStats.OnFrameListener = JankStats.OnFrameListener { frameData ->
    // Make sure to only log janky frames.
    if (frameData.isJank) {
        bark(priority = LogPriority.VERBOSE, tag = "Jank") { frameData.toString() }
    }
}


fun provideWindow(activity: Activity): Window = activity.window

fun provideJankStats(window: Window, frameListener: JankStats.OnFrameListener): JankStats {
    return JankStats.createAndTrack(window, frameListener)
}