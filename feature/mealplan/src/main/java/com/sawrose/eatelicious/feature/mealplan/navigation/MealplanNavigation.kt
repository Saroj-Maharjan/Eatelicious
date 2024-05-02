package com.sawrose.eatelicious.feature.mealplan.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sawrose.eatelicious.feature.mealplan.MealPlanRoute

const val mealPlanRoute = "mealplan_route"

fun NavController.navigateToMealPlan(navOptions: NavOptions? = null){
    this.navigate(mealPlanRoute, navOptions)
}

fun NavGraphBuilder.mealplanScreen(){
    composable(route = mealPlanRoute){
        MealPlanRoute()
    }
}
