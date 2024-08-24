package com.sawrose.eatelicious.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SnackbarDuration.Short
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.util.fastFirstOrNull
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.sawrose.eatelicious.core.designsystem.component.ScreenBackground
import com.sawrose.eatelicious.core.designsystem.navigation.LocalNavigationMode
import com.sawrose.eatelicious.core.designsystem.navigation.NavigationModeDefaults.calculateFromAdaptiveInfo
import com.sawrose.eatelicious.core.designsystem.navigation.NavigationSuiteScaffold
import com.sawrose.eatelicious.core.designsystem.navigation.ProvideNavigationItems
import com.sawrose.eatelicious.core.designsystem.navigation.drawer.NavigationDrawerLayout
import com.sawrose.eatelicious.navigation.EateliciousNavHost
import com.sawrose.eatelicious.navigation.navigationItems
import com.sawrose.eatelicious.navigation.provideMenuProvider

@Composable
fun EateliciousApp(
    modifier: Modifier = Modifier,
    windowSize: WindowSizeClass,
) {
    ScreenBackground(modifier) {
        val snackBarStateHost = remember { SnackbarHostState() }

        EateliciousApp(
            snackbarHostState = snackBarStateHost,
            windowSize = windowSize,
        )
    }
}


@Composable
internal fun EateliciousApp(
    snackbarHostState: SnackbarHostState,
    modifier: Modifier = Modifier,
    windowSize: WindowSizeClass,
) {
    val navController = rememberNavController()
    val currentBackstackEntry by navController.currentBackStackEntryAsState()
    val selectedDestination by remember {
        derivedStateOf {
            val currentDestination = currentBackstackEntry?.destination?.parent?.route
            navigationItems.fastFirstOrNull { it.route == currentDestination }
        }
    }

    ProvideNavigationItems(
        selectedNavigationItem = selectedDestination,
        bottomNavigationItems = navigationItems,
        navigationRailItems = navigationItems,
        navigationDrawerItems = navigationItems,
    ) {
        CompositionLocalProvider(
            LocalNavigationMode provides calculateFromAdaptiveInfo(currentWindowAdaptiveInfo()),
        ) {
            NavigationDrawerLayout(
                drawerHeaderContent = {
                    DrawerSection(navController)
                },
                onNavigationItemClick = {
                    navController.navigate(it.route)
                },
            ) {

                NavigationSuiteScaffold(
                    title = { Text(text = selectedDestination?.route ?: "Eatelicious") },
                    onNavigate = {
                        navController.navigate(it)
                    },
                ) {
                    provideMenuProvider()
                    EateliciousNavHost(
                        Modifier.padding(it),
                        navController,
                        onShowSnackbar = { message, action ->
                            snackbarHostState.showSnackbar(
                                message = message,
                                actionLabel = action,
                                duration = Short,
                            ) == SnackbarResult.ActionPerformed
                        },
                    )
                }
            }
        }

    }
}
