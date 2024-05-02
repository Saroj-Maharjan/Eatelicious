package com.sawrose.eatelicious.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.sawrose.eatelicious.feature.bookmark.navigation.bookmarkScreen
import com.sawrose.eatelicious.feature.discover.navigation.discoverRoute
import com.sawrose.eatelicious.feature.discover.navigation.discoverScreen
import com.sawrose.eatelicious.feature.mealplan.navigation.mealplanScreen
import com.sawrose.eatelicious.ui.EateliciousAppState

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
      discoverScreen()
      bookmarkScreen()
      mealplanScreen()
  }
}
