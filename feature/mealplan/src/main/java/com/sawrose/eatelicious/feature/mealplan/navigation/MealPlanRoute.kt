package com.sawrose.eatelicious.feature.mealplan.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sawrose.eatelicious.feature.mealplan.MealPlanRoute

const val MEAL_PLAN_ROUTE = "meal_plan"
fun NavController.navigateToMealPlan(navOptions: NavOptions) = navigate(MEAL_PLAN_ROUTE, navOptions)

fun NavGraphBuilder.mealPlanScreen() {
    composable(MEAL_PLAN_ROUTE) {
        MealPlanRoute()
    }
}
