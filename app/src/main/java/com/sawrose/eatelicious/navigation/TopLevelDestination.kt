package com.sawrose.eatelicious.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.EventNote
import androidx.compose.material.icons.automirrored.outlined.EventNote
import androidx.compose.material.icons.filled.BlurOn
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.EventNote
import androidx.compose.material.icons.outlined.BlurOn
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.EventNote
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector
import com.sawrose.eatelicious.commons.navigation.DiscoverScreen
import com.slack.circuit.runtime.screen.Screen

@Immutable
data class TopLevelDestination(
    val screen: Screen,
    val title: String,
    val contentDescription: String,
    val iconImageVector: ImageVector,
    val selectedImageVector: ImageVector,
)

fun buildNavigationItems(): List<TopLevelDestination> {
    return listOf(
        TopLevelDestination(
            DiscoverScreen(),
            title = "Discover",
            contentDescription = "Discover",
            iconImageVector = Icons.Outlined.BlurOn,
            selectedImageVector = Icons.Filled.BlurOn
        ),
        TopLevelDestination(
            DiscoverScreen(),
            title = "Bookmark",
            contentDescription = "Bookmark",
            iconImageVector = Icons.Outlined.Bookmark,
            selectedImageVector = Icons.Filled.Bookmark
        ),
        TopLevelDestination(
            DiscoverScreen(),
            title = "Meal Plan",
            contentDescription = "Meal Plan",
            iconImageVector = Icons.AutoMirrored.Outlined.EventNote,
            selectedImageVector = Icons.AutoMirrored.Filled.EventNote
        )
    )
}
