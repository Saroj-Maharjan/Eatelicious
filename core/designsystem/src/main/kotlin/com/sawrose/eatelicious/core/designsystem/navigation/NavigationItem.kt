package com.sawrose.eatelicious.core.designsystem.navigation

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Describes a single item in the navigation drawer displayed in navigation-related UI.
 *
 * @property icon an [ImageVector] used to represent the nav destination.
 * @property labelRes a string resource representing the label of the nav destination.
 * @property route the route to navigate to when the item is clicked.
 * */
data class NavigationItem(
    val icon: ImageVector,
    @StringRes val labelRes: Int,
    val route: String,
)

internal val LocalBottomNavigationItems = compositionLocalOf<List<NavigationItem>> {
    emptyList()
}

internal val LocalNavigationRailItems = compositionLocalOf<List<NavigationItem>> {
    emptyList()
}

internal val LocalNavigationDrawerItems = compositionLocalOf<List<NavigationItem>> {
    emptyList()
}

internal val LocalSelectedNavigationItem = compositionLocalOf<NavigationItem?> {
    null
}

/**
 * Provides the navigation items to the children composables.
 *
 * @param selectedNavigationItem the currently selected navigation item.
 * @param bottomNavigationItems a list of [NavigationItem]s to be displayed in the bottom navigation bar.
 * @param navigationRailItems a list of [NavigationItem]s to be displayed in the navigation rail.
 * @param navigationDrawerItems a list of [NavigationItem]s to be displayed in the navigation drawer.
 * @param content the content to be displayed.
 * */
@Composable
fun ProvideNavigationItems(
    selectedNavigationItem: NavigationItem?,
    bottomNavigationItems: List<NavigationItem>,
    navigationRailItems: List<NavigationItem>,
    navigationDrawerItems: List<NavigationItem>,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalSelectedNavigationItem provides selectedNavigationItem,
        LocalBottomNavigationItems provides bottomNavigationItems,
        LocalNavigationRailItems provides navigationRailItems,
        LocalNavigationDrawerItems provides navigationDrawerItems,
        content = content,
    )
}
