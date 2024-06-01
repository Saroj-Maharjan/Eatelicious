package com.sawrose.eatelicious.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BlurOn
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.EventNote
import androidx.compose.material.icons.outlined.BlurOn
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.EventNote
import androidx.compose.ui.graphics.vector.ImageVector
import com.sawrose.eatelicious.R

enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val iconTextId: Int,
    val titleTextId: Int,
) {
    DISCOVER(
        selectedIcon = Icons.Filled.BlurOn,
        unSelectedIcon = Icons.Outlined.BlurOn,
        iconTextId = R.string.discover,
        titleTextId = R.string.discover,
    ),
    BOOKMARK(
        selectedIcon = Icons.Filled.Bookmark,
        unSelectedIcon = Icons.Outlined.Bookmark,
        iconTextId = R.string.Bookmark,
        titleTextId = R.string.Bookmark,
    ),
    MEAL_PLAN(
        selectedIcon = Icons.Filled.EventNote,
        unSelectedIcon = Icons.Outlined.EventNote,
        iconTextId = R.string.MealPlan,
        titleTextId = R.string.MealPlan,
    ),
}
