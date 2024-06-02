package com.sawrose.eatelicious.feature.bookmark.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sawrose.eatelicious.feature.bookmark.BookmarkScreen

const val BOOKMARK_ROUTE = "bookmark"
fun NavController.navigateToBookmark(navOptions: NavOptions) = navigate(BOOKMARK_ROUTE, navOptions)

fun NavGraphBuilder.bookmarkScreen() {
    composable(BOOKMARK_ROUTE) {
        BookmarkScreen()
    }
}
