package com.sawrose.eatelicious.feature.discover.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sawrose.eatelicious.core.model.Recipe
import com.sawrose.eatelicious.feature.discover.DiscoverRoute
import com.sawrose.eatelicious.feature.discover.DiscoverViewmodel
import org.koin.androidx.compose.koinViewModel

const val discoverRoute = "discover_route"

fun NavController.navigateToDiscover(navOptions: NavOptions? = null){
    this.navigate(discoverRoute, navOptions)
}

fun NavGraphBuilder.discoverScreen(
    onRecipeClicked: (Recipe) -> Unit,
){
    composable(
        route = discoverRoute
    ){
        val viewmodel: DiscoverViewmodel = koinViewModel()
        val uiState by viewmodel.discoveruiState.collectAsState()
        DiscoverRoute(
            uiState = uiState,
            onRecipeClicked = onRecipeClicked,
            handleEvent = viewmodel::handleEvent
        )
    }
}