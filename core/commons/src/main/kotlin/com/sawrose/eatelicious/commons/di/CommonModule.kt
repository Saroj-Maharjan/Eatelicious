package com.sawrose.eatelicious.commons.di

import android.app.Activity
import android.view.Window
import androidx.metrics.performance.JankStats
import com.sawrose.eatelicious.commons.dispatcher.DispatcherProvider
import com.sawrose.eatelicious.commons.dispatcher.StandardDispatcherProvider
import com.sawrose.eatelicious.core.model.LogLevel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val commonModule = module {
    single { provideWindow(get()) }
    single { provideJankStats(get(), get()) }
    singleOf(::StandardDispatcherProvider) {
        bind<DispatcherProvider>()
    }
}

fun provideWindow(activity: Activity): Window = activity.window

fun provideJankStats(window: Window, frameListener: JankStats.OnFrameListener): JankStats {
    return JankStats.createAndTrack(window, frameListener)
}
