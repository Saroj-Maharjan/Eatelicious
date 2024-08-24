package com.sawrose.eatelicious.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.sawrose.eatelicious.feature.bookmark.navigation.bookmarkScreen
import com.sawrose.eatelicious.feature.discover.navigation.DISCOVER_ROUTE
import com.sawrose.eatelicious.feature.discover.navigation.discoverScreen
import com.sawrose.eatelicious.feature.mealplan.navigation.mealPlanScreen
import com.sawrose.eatelicious.feature.navigation.logfileScreen

/**
 * The navigation graph defined in this file defines the different top level routes. Navigation
 * within each route is handled using state and Back Handlers.
 * */
@Composable
fun EateliciousNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    onShowSnackbar: suspend (String, String?) -> Boolean,
    startDestination: String = DISCOVER_ROUTE,
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        discoverScreen(
            onShowSnackbar = onShowSnackbar,
            onRecipeClicked = {},
        )
        bookmarkScreen()
        mealPlanScreen()

        logfileScreen()
    }
}
