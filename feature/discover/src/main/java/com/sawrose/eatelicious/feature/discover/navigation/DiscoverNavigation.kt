package com.sawrose.eatelicious.feature.discover.navigation

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sawrose.eatelicious.core.model.Recipe
import com.sawrose.eatelicious.feature.discover.DiscoverRoute
import com.sawrose.eatelicious.feature.discover.DiscoverViewmodel
import org.koin.androidx.compose.koinViewModel

const val DISCOVER_ROUTE = "discover"
fun NavController.navigateToDiscover(navOptions: NavOptions) = navigate(DISCOVER_ROUTE, navOptions)

fun NavGraphBuilder.discoverScreen(
    onShowSnackbar: suspend (String, String?) -> Boolean,
    onRecipeClicked: (Recipe) -> Unit,
) {
    composable(DISCOVER_ROUTE) {
        val viewmodel: DiscoverViewmodel = koinViewModel()
        val uiState by viewmodel.discoveruiState.collectAsStateWithLifecycle()
        DiscoverRoute(
            uiState,
            onShowSnackbar,
            onRecipeClicked,
            viewmodel::handleEvent,
        )
    }
}
