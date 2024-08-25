package com.sawrose.eatelicious.feature.bookmark.navigation

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sawrose.eatelicious.feature.bookmark.BookmarkPage
import com.sawrose.eatelicious.feature.bookmark.BookmarkViewmodel
import org.koin.androidx.compose.koinViewModel

const val BOOKMARK_ROUTE = "bookmark"
fun NavController.navigateToBookmark(navOptions: NavOptions) = navigate(BOOKMARK_ROUTE, navOptions)

fun NavGraphBuilder.bookmarkScreen() {
    composable(BOOKMARK_ROUTE) {
        val viewmodel = koinViewModel<BookmarkViewmodel>()

        val uiState by viewmodel.uiState.collectAsStateWithLifecycle()
        BookmarkPage(
            uiState = uiState,
        )
    }
}
