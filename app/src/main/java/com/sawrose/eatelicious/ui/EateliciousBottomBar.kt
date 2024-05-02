package com.sawrose.eatelicious.ui

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.sawrose.eatelicious.core.designsystem.component.EateliciousNavigationBar
import com.sawrose.eatelicious.core.designsystem.component.EateliciousNavigationBarItem
import com.sawrose.eatelicious.navigation.TopLevelDestination

@Composable
fun EateliciousBottomBar(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier
) {
  EateliciousNavigationBar(modifier = modifier) {
    destinations.forEach { destination ->
      val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)
      EateliciousNavigationBarItem(
          selected = selected,
          onClick = { onNavigateToDestination(destination) },
          icon = { Icon(imageVector = destination.unSelectedIcon, contentDescription = null) },
          selectedIcon = { Icon(imageVector = destination.selectedIcon, contentDescription = null) },
          label = { Text(stringResource(destination.iconTextId)) },
          modifier = modifier,
      )
    }
  }
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any { it.route?.contains(destination.name, true) ?: false } ?: false
