package com.sawrose.eatelicious.core.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onSubscription

abstract class Navigator {
    val navigationCommands = MutableSharedFlow<NavigationCommand>(extraBufferCapacity = Int.MAX_VALUE)

    val navControllerFlow = MutableStateFlow<NavController?>(null)

    fun navigateUp(){
        navigationCommands.tryEmit(NavigationCommand.NavigateUp)
    }
}

abstract class AppComposeNavigator<T: Any> : Navigator() {
    abstract fun navigate(route: T, optionBuilder: (NavOptionsBuilder.() -> Unit)? = null)
    abstract fun navigateBackWithResult(key: String, result: Any, route: T?)

    abstract fun popBackStack(route: T, inclusive: Boolean)
    abstract fun navigateAndClearBackStack(route: T)

    suspend fun handleNavigationCommand(navController: NavController){
        navigationCommands
            .onSubscription { this@AppComposeNavigator.navControllerFlow.value = navController }
            .onCompletion { this@AppComposeNavigator.navControllerFlow.value = null }
            .collect{ navController.handleComposeNavigationCommand(it) }
    }

    private fun NavController.handleComposeNavigationCommand(command: NavigationCommand){
        when(command){
            is NavigationCommand.NavigateUp -> navigateUp()
            is ComposeNavigationCommand.NavigateToRoute<*> -> {
                navigate(command.route, command.options)
            }
            is ComposeNavigationCommand.NavigateUpWithResult<*, *> -> {
                navUpWithResult(command)
            }
            is ComposeNavigationCommand.PopBackStack<*> -> {
                popBackStack(command.route, command.inclusive)
            }
        }
    }

    private fun NavController.navUpWithResult(
        navigationCommand: ComposeNavigationCommand.NavigateUpWithResult<*, *>
    ) {
        val backStackEntry = navigationCommand.route?.let { getBackStackEntry(it) }
        backStackEntry?.savedStateHandle?.set(
            navigationCommand.key,
            navigationCommand.result
        )
        navigationCommand.route?.let {
            popBackStack(it, false)
        }?: navigateUp()
    }
}