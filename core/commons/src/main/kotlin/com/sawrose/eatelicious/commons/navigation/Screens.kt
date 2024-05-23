package com.sawrose.eatelicious.commons.navigation

import com.slack.circuit.runtime.screen.Screen
import kotlinx.parcelize.Parcelize

@Parcelize
class RootScreen : EateliciousScreen("Root")

@Parcelize
class DiscoverScreen : EateliciousScreen("Discover")

@Parcelize
class BookmarkScreen : EateliciousScreen("Bookmark")

@Parcelize
class MealPlanScreen : EateliciousScreen("MealPlan")

abstract class EateliciousScreen(val name: String) : Screen {
    open val arguments: Map<String, *>? = null
    open val presentation: Presentation = Presentation()
}

data class Presentation(
    val hideBottomBar: Boolean = false,
    val isDetailOpen: Boolean = false,
)
