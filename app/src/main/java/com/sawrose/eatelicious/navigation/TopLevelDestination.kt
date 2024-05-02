package com.sawrose.eatelicious.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BlurOn
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.EventNote
import androidx.compose.material.icons.outlined.BlurOn
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.EventNote
import androidx.compose.material.icons.outlined.Note
import androidx.compose.ui.graphics.vector.ImageVector
import com.sawrose.eatelicious.R

enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val iconTextId: Int,
    val titleTextId: Int,
) {
  DISCOVER(
      selectedIcon = Icons.Outlined.BlurOn,
      unSelectedIcon = Icons.Filled.BlurOn,
      iconTextId = R.string.discover,
      titleTextId = R.string.app_name),
  BOOKMARK(
      selectedIcon = Icons.Outlined.Bookmark,
      unSelectedIcon = Icons.Filled.Bookmark,
      iconTextId = R.string.Bookmark,
      titleTextId = R.string.Bookmark),
  MEALPLAN(
      selectedIcon = Icons.Outlined.EventNote,
      unSelectedIcon = Icons.Filled.EventNote,
      iconTextId = R.string.MealPlan,
      titleTextId = R.string.MealPlan)
}
