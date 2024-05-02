package com.sawrose.eatelicious.ui

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.sawrose.eatelicious.feature.bookmark.navigation.bookmarkRoute
import com.sawrose.eatelicious.feature.bookmark.navigation.navigateToBookmark
import com.sawrose.eatelicious.feature.discover.navigation.discoverRoute
import com.sawrose.eatelicious.feature.discover.navigation.navigateToDiscover
import com.sawrose.eatelicious.feature.mealplan.navigation.mealPlanRoute
import com.sawrose.eatelicious.feature.mealplan.navigation.navigateToMealPlan
import com.sawrose.eatelicious.navigation.TopLevelDestination
import com.sawrose.eatelicious.navigation.TopLevelDestination.BOOKMARK
import com.sawrose.eatelicious.navigation.TopLevelDestination.DISCOVER
import com.sawrose.eatelicious.navigation.TopLevelDestination.MEALPLAN
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberEateliciousAppState(
    windowSizeClass: WindowSizeClass,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
): EateliciousAppState {
  return remember(
      navController,
      coroutineScope,
      windowSizeClass,
  ) {
    EateliciousAppState(
        navController,
        coroutineScope,
        windowSizeClass,
    )
  }
}

@Stable
class EateliciousAppState(
    val navController: NavHostController,
    val coroutineScope: CoroutineScope,
    val windowSizeClass: WindowSizeClass
) {
  val currentDestination: NavDestination?
    @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when(currentDestination?.route){
            discoverRoute -> DISCOVER
            bookmarkRoute -> BOOKMARK
            mealPlanRoute -> MEALPLAN
            else -> null
        }
    val shouldShowBottomBar: Boolean
        get() = windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact

    val shouldShowNavRail: Boolean
        get() = !shouldShowBottomBar

    /**
     * Map of top level destinations to be used in the TopBar, BottomBar and NavRail. The key is the
     * route.
     */

    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.values().asList()

    /**
     * UI logic for navigating to a top level destination in the app. Top level destinations have
     * only one copy of the destination of the back stack, and save and restore state whenever you
     * navigate to and from it.
     *
     * @param topLevelDestination: The destination the app needs to navigate to.
     */
    fun navigateToTopLevelDestinations(topLevelDestination: TopLevelDestination){
        val topLevelOptions = navOptions {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reelecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }

        when(topLevelDestination) {
            DISCOVER -> navController.navigateToDiscover(topLevelOptions)
            BOOKMARK -> navController.navigateToBookmark(topLevelOptions)
            MEALPLAN -> navController.navigateToMealPlan(topLevelOptions)
        }
    }
}
