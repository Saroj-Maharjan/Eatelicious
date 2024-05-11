package com.sawrose.eatelicious.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.sawrose.eatelicious.feature.bookmark.navigation.bookmarkScreen
import com.sawrose.eatelicious.feature.discover.navigation.discoverRoute
import com.sawrose.eatelicious.feature.discover.navigation.discoverScreen
import com.sawrose.eatelicious.feature.mealplan.navigation.mealplanScreen
import com.sawrose.eatelicious.ui.EateliciousAppState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun EateliciousNavHost(
    appState: EateliciousAppState,
    onShowSnackbar: suspend (String, String?) -> Boolean,
    modifier: Modifier = Modifier,
    startDestination: String = discoverRoute,
) {
    val navController = appState.navController

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        discoverScreen(
            onRecipeClicked = { recipe ->
                CoroutineScope(Dispatchers.IO).launch {
                    onShowSnackbar("Recipe clicked: ${recipe.name}", null)
                }
            }
        )
        bookmarkScreen()
        mealplanScreen()
    }
}
