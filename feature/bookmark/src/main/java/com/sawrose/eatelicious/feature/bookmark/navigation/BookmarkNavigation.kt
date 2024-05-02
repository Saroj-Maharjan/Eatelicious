package com.sawrose.eatelicious.feature.bookmark.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sawrose.eatelicious.feature.bookmark.BookmarkRoute

const val bookmarkRoute = "bookmark_route"

fun NavController.navigateToBookmark(navOptions: NavOptions? = null){
    navigate(bookmarkRoute, navOptions)
}

fun NavGraphBuilder.bookmarkScreen(){
    composable(route = bookmarkRoute){
        BookmarkRoute()
    }
}