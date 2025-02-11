package com.sawrose.eatelicious

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.metrics.performance.JankStats
import com.sawrose.eatelicious.core.designsystem.theme.EateliciousTheme
import com.sawrose.eatelicious.ui.EateliciousApp
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : ComponentActivity() {

    /**
     * Lazily inject [JankStats], which is used to track jank throughout the app.
     */
    val lazyStats: JankStats by inject { parametersOf(this) }

    private var shouldKeepSplashOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        setupSplashScreen()
        super.onCreate(savedInstanceState)

        // Turn off the decor fitting system windows, which allows us to handle insets,
        // including IME animations, and go edge-to-edge
        // This also sets up the initial system bar style based on the platform theme
        enableEdgeToEdge()

        setContent {
            CompositionLocalProvider {
                EateliciousTheme {
                    EateliciousApp()
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        lazyStats.isTrackingEnabled = true
    }

    override fun onPause() {
        super.onPause()
        lazyStats.isTrackingEnabled = false
    }

    private fun setupSplashScreen() {
        //        Waiting util the randomRecipe is loaded.
        installSplashScreen().setKeepOnScreenCondition(::shouldKeepSplashOpen)
    }
}
