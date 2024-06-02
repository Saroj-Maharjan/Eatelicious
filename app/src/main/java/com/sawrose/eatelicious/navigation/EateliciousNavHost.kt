package com.sawrose.eatelicious.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.sawrose.eatelicious.feature.bookmark.navigation.bookmarkScreen
import com.sawrose.eatelicious.feature.discover.navigation.DISCOVER_ROUTE
import com.sawrose.eatelicious.feature.discover.navigation.discoverScreen
import com.sawrose.eatelicious.feature.mealplan.navigation.mealPlanScreen
import com.sawrose.eatelicious.ui.EatecliciousAppState


/**
 * The navigation graph defined in this file defines the different top level routes. Navigation
 * within each route is handled using state and Back Handlers.
 * */
@Composable
fun EateliciousNavHost(
    appState: EatecliciousAppState,
    onShowSnackbar: suspend (String, String?) -> Boolean,
    modifier: Modifier = Modifier,
    startDestination: String = DISCOVER_ROUTE,
) {
    val navController = appState.navController

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ){
        discoverScreen(onRecipeClicked = {})
        bookmarkScreen()
        mealPlanScreen()
    }
}