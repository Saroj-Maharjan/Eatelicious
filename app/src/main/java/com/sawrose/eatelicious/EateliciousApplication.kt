package com.sawrose.eatelicious

import android.app.Application
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.sawrose.eatelicious.core.logging.Heartwood
import com.sawrose.eatelicious.core.logging.bark
import com.sawrose.eatelicious.core.logging.logging.AndroidBark
import com.sawrose.eatelicious.core.model.LogLevel
import com.sawrose.eatelicious.di.eateliciousAppModule
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import kotlin.system.exitProcess

class EateliciousApplication : Application() {

    private val bark: AndroidBark by inject()

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@EateliciousApplication)
            modules(
                eateliciousAppModule,
            )
        }

        Heartwood.grow(
            bark,
        )

        Thread.setDefaultUncaughtExceptionHandler { _, e ->
            handleUncaughtException(e)
        }
    }

    private fun handleUncaughtException(ex: Throwable) {
        bark(LogLevel.Error, throwable = ex) { "Uncaught exception" }
        FirebaseCrashlytics.getInstance().recordException(ex)
        exitProcess(1)
    }
}
