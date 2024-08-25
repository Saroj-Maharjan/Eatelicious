package com.sawrose.eatelicious.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BlurOn
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.EventNote
import com.sawrose.eatelicious.R
import com.sawrose.eatelicious.core.designsystem.navigation.NavigationItem

val navigationItems = listOf(
    NavigationItem(
        icon = Icons.Filled.BlurOn,
        labelRes = R.string.discover,
        route = "discover",
    ),
    NavigationItem(
        icon = Icons.Filled.Bookmark,
        labelRes = R.string.Bookmark,
        route = "bookmark",
    ),
    NavigationItem(
        icon = Icons.Filled.EventNote,
        labelRes = R.string.MealPlan,
        route = "meal_plan",
    ),
)
