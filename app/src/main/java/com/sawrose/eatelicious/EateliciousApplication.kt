package com.sawrose.eatelicious

import android.app.Application
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.sawrose.eatelicious.core.logging.Heartwood
import com.sawrose.eatelicious.core.logging.LogPriority
import com.sawrose.eatelicious.core.logging.bark
import com.sawrose.eatelicious.di.eateliciousAppModule
import com.sawrose.eatelicious.logging.AndroidBark
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import kotlin.system.exitProcess

class EateliciousApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Heartwood.grow(
            AndroidBark(),
        )
        startKoin {
            androidLogger()
            androidContext(this@EateliciousApplication)
            modules(
                eateliciousAppModule,
            )
        }

        Thread.setDefaultUncaughtExceptionHandler { _, e ->
            handleUncaughtException(e)
        }
    }

    private fun handleUncaughtException(ex: Throwable) {
        bark(LogPriority.ERROR, throwable = ex) { "Uncaught exception" }
//        FirebaseCrashlytics.getInstance().recordException(ex)
        exitProcess(1)
    }
}
