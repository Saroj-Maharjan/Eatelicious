package com.sawrose.eatelicious.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import com.sawrose.eatelicious.commons.navigation.RootScreen
import com.sawrose.eatelicious.navigation.NavigationType
import com.sawrose.eatelicious.navigation.buildNavigationItems
import com.slack.circuit.backstack.SaveableBackStack
import com.slack.circuit.foundation.NavigableCircuitContent
import com.slack.circuit.runtime.Navigator

@OptIn(
    ExperimentalComposeUiApi::class,
    ExperimentalMaterial3Api::class,
)
@Composable
fun MainComposeApp(
    backstack: SaveableBackStack,
    navigator: Navigator,
    windowSizeClass: WindowSizeClass,
) {
    val navigationType = remember(windowSizeClass) {
        NavigationType.forWindowSizeSize(windowSizeClass)
    }

    val rootScreen by remember(backstack) {
        derivedStateOf { backstack.last().screen }
    }

    val snackBarStateHost = remember { SnackbarHostState() }
    Scaffold(
        modifier = Modifier.semantics { testTagsAsResourceId = true },
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.onBackground,
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        snackbarHost = { SnackbarHost(snackBarStateHost) },
        bottomBar = {
            if (navigationType == NavigationType.BOTTOM_NAVIGATION) {
                EateliciousBottomBar(
                    currentDestination = rootScreen,
                    destinations = buildNavigationItems(),
                    onNavigateToDestination = { navigator.resetRoot(RootScreen()) },
                    modifier = Modifier.testTag("EateliciousBottomBar"),
                )
            } else {
                Spacer(
                    Modifier
                        .windowInsetsBottomHeight(WindowInsets.navigationBars)
                        .fillMaxWidth(),
                )
            }
        },
    ) { padding ->
        Row(
            modifier =
            Modifier
                .fillMaxSize()
                .padding(padding)
                .consumeWindowInsets(padding)
                .windowInsetsPadding(
                    WindowInsets.safeDrawing.only(WindowInsetsSides.Horizontal),
                ),
        ) {
            Column(Modifier.fillMaxSize()) {
                NavigableCircuitContent(
                    navigator = navigator,
                    backStack = backstack,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                )

//                EateliciousNavHost(
//                    appState = appState,
//                    onShowSnackbar = { message, action ->
//                        snackBarStateHost.showSnackbar(
//                            message = message,
//                            actionLabel = action,
//                            duration = SnackbarDuration.Short,
//                        ) == SnackbarResult.ActionPerformed
//                    })
            }
        }
    }
}
