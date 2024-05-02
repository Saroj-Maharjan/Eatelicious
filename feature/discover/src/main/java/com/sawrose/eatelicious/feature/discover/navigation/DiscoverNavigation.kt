package com.sawrose.eatelicious.feature.discover.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sawrose.eatelicious.feature.discover.DiscoverRoute

const val discoverRoute = "discover_route"

fun NavController.navigateToDiscover(navOptions: NavOptions? = null){
    this.navigate(discoverRoute, navOptions)
}

fun NavGraphBuilder.discoverScreen(){
    composable(
        route = discoverRoute
    ){
        DiscoverRoute()
    }
}