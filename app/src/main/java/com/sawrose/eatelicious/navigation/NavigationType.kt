package com.sawrose.eatelicious.navigation

import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass

enum class NavigationType {
    BOTTOM_NAVIGATION,
    RAIL,
    PERMANENT_DRAWER,
    ;

    companion object {
        fun forWindowSizeSize(windowSizeClass: WindowSizeClass): NavigationType = when {
            windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact -> BOTTOM_NAVIGATION
            windowSizeClass.heightSizeClass == WindowHeightSizeClass.Compact -> BOTTOM_NAVIGATION
            windowSizeClass.widthSizeClass == WindowWidthSizeClass.Medium -> RAIL
            windowSizeClass.widthSizeClass == WindowWidthSizeClass.Expanded -> PERMANENT_DRAWER
            else -> RAIL
        }
    }
}
