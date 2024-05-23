package com.sawrose.eatelicious

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.sawrose.eatelicious.commons.navigation.RootScreen
import com.sawrose.eatelicious.core.designsystem.theme.EateliciousTheme
import com.sawrose.eatelicious.ui.MainComposeApp
import com.slack.circuit.backstack.rememberSaveableBackStack
import com.slack.circuit.foundation.rememberCircuitNavigator

class MainActivity : ComponentActivity() {

    private var shouldKeepSplashOpen = false

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        setupSplashScreen()
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val backstack = rememberSaveableBackStack(listOf(RootScreen()))
            val navigator = rememberCircuitNavigator(backstack)
            EateliciousTheme {
                MainComposeApp(
                    backstack = backstack,
                    navigator = navigator,
                    windowSizeClass = calculateWindowSizeClass(this)
                )
            }
        }
    }

    private fun setupSplashScreen() {
        //        Waiting util the data is loaded.
        installSplashScreen().setKeepOnScreenCondition(::shouldKeepSplashOpen)
    }
}
