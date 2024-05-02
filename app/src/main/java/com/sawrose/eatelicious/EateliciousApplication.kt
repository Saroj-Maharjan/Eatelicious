package com.sawrose.eatelicious

import android.app.Application
import com.sawrose.eatelicious.commons.commonModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class EateliciousApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@EateliciousApplication)
            modules(
                commonModule
            )
        }

    }
}