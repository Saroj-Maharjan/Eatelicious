package com.sawrose.eatelicious.ui

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.sawrose.eatelicious.core.designsystem.component.EateliciousNavigationBar
import com.sawrose.eatelicious.core.designsystem.component.EateliciousNavigationBarItem
import com.sawrose.eatelicious.navigation.TopLevelDestination
import com.slack.circuit.runtime.screen.Screen

@Composable
fun EateliciousBottomBar(
    currentDestination: Screen?,
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    modifier: Modifier = Modifier,
) {
    EateliciousNavigationBar(modifier = modifier) {
        destinations.forEach { destination ->
            val selected = currentDestination == destination.screen
            EateliciousNavigationBarItem(
                label = { Text(destination.title) },
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    Icon(
                        imageVector = destination.iconImageVector,
                        contentDescription = null
                    )
                },
                selectedIcon = {
                    Icon(
                        imageVector = destination.selectedImageVector,
                        contentDescription = null
                    )
                },
                modifier = modifier,
            )
        }
    }
}
