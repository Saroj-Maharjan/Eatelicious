package com.sawrose.eatelicious.ui

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import com.sawrose.eatelicious.core.designsystem.component.EateliciousTopAppBar
import com.sawrose.eatelicious.navigation.EateliciousNavHost

@OptIn(
    ExperimentalLayoutApi::class, ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MainComposeApp(
    windowSizeClass: WindowSizeClass,
    appState: EateliciousAppState =
        rememberEateliciousAppState(
            windowSizeClass = windowSizeClass,
        )
) {
  val snackBarStateHost = remember { SnackbarHostState() }
  Scaffold(
      modifier = Modifier.semantics { testTagsAsResourceId = true },
      containerColor = Color.Transparent,
      contentColor = MaterialTheme.colorScheme.onBackground,
      contentWindowInsets = WindowInsets(0, 0, 0, 0),
      snackbarHost = { SnackbarHost(snackBarStateHost) },
      bottomBar = {
        if (appState.shouldShowBottomBar) {
          EateliciousBottomBar(
              destinations = appState.topLevelDestinations,
              onNavigateToDestination = appState::navigateToTopLevelDestinations,
              currentDestination = appState.currentDestination,
              modifier = Modifier.testTag("EateliciousBottomBar"),
          )
        }
      }) { padding ->
        Row(
            modifier =
                Modifier.fillMaxSize()
                    .padding(padding)
                    .consumeWindowInsets(padding)
                    .windowInsetsPadding(
                        WindowInsets.safeDrawing.only(WindowInsetsSides.Horizontal))) {
              Column(Modifier.fillMaxSize()) {
                val destination = appState.currentTopLevelDestination
                if (destination != null) {
                  EateliciousTopAppBar(
                      titleRes = destination.titleTextId,
                      colors =
                          TopAppBarDefaults.centerAlignedTopAppBarColors(
                              containerColor = Color.Transparent
                          ))
                }

                EateliciousNavHost(
                    appState = appState,
                    onShowSnackbar = { message, action ->
                      snackBarStateHost.showSnackbar(
                          message = message,
                          actionLabel = action,
                          duration = SnackbarDuration.Short,
                      ) == SnackbarResult.ActionPerformed
                    })
              }
            }
      }
}
