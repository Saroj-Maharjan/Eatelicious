package com.sawrose.eatelicious.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.util.trace
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.sawrose.eatelicious.commons.utils.TrackDisposableJank
import com.sawrose.eatelicious.feature.bookmark.navigation.BOOKMARK_ROUTE
import com.sawrose.eatelicious.feature.bookmark.navigation.navigateToBookmark
import com.sawrose.eatelicious.feature.discover.navigation.DISCOVER_ROUTE
import com.sawrose.eatelicious.feature.discover.navigation.navigateToDiscover
import com.sawrose.eatelicious.feature.mealplan.navigation.MEAL_PLAN_ROUTE
import com.sawrose.eatelicious.feature.mealplan.navigation.navigateToMealPlan
import com.sawrose.eatelicious.navigation.TopLevelDestination
import com.sawrose.eatelicious.navigation.TopLevelDestination.BOOKMARK
import com.sawrose.eatelicious.navigation.TopLevelDestination.DISCOVER
import com.sawrose.eatelicious.navigation.TopLevelDestination.MEAL_PLAN
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberEatecliciousAppState(
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
): EatecliciousAppState {
    NavigationTrackingSideEffect(navController)
    return remember(
        coroutineScope,
        navController,
    ) {
        EatecliciousAppState(
            coroutineScope = coroutineScope,
            navController = navController,
        )
    }
}

@Stable
class EatecliciousAppState(
    coroutineScope: CoroutineScope,
    val navController: NavHostController,
) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val currentTopDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            DISCOVER_ROUTE -> DISCOVER
            BOOKMARK_ROUTE -> BOOKMARK
            MEAL_PLAN_ROUTE -> MEAL_PLAN
            else -> null
        }

    /**
     * Map of top level destinations to be used in the TopBar, BottomBar and NavRail. The key is the
     * route.
     */
    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.entries

    /**
     * UI logic for navigating to a top level destination in the app. Top level destinations have
     * only one copy of the destination of the back stack, and save and restore state whenever you
     * navigate to and from it.
     *
     * @param topLevelDestination: The destination the app needs to navigate to.
     */
    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        trace("Navigation: ${topLevelDestination.name}") {
            val topLevelNavOption = navOptions {
                // Pop up to the start destination of the graph to
                // avoid building up a large stack of destinations
                // on the back stack as users select items
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                // Avoid multiple copies of the same destination when
                // reselecting the same item
                launchSingleTop = true
                // Restore state when reselecting a previously selected item
                restoreState = true
            }
            when (topLevelDestination) {
                DISCOVER -> navController.navigateToDiscover(topLevelNavOption)
                BOOKMARK -> navController.navigateToBookmark(topLevelNavOption)
                MEAL_PLAN -> navController.navigateToMealPlan(topLevelNavOption)
            }
        }
    }
}

@Composable
private fun NavigationTrackingSideEffect(navController: NavHostController) {
    TrackDisposableJank(navController) { metricHolder ->
        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
            metricHolder.state?.putState("Navigation", destination.route.toString())
        }

        navController.addOnDestinationChangedListener(listener)

        onDispose {
            navController.removeOnDestinationChangedListener(listener)
        }
    }

}