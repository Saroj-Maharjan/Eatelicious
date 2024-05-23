package com.sawrose.eatelicious

import android.app.Application
import com.sawrose.eatelicious.core.logging.Heartwood
import com.sawrose.eatelicious.di.eateliciousAppModule
import com.sawrose.eatelicious.logging.AndroidBark
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

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
    }
}
