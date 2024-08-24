package com.sawrose.eatelicious.core.designsystem.navigation.topbars

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.boswelja.menuprovider.LocalMenuHost
import com.boswelja.menuprovider.MenuHost
import com.boswelja.menuprovider.material3.AnimatedTopAppBarMenuItems
import com.sawrose.eatelicious.core.designsystem.navigation.drawer.LocalModalDrawerController
import com.sawrose.eatelicious.core.designsystem.navigation.drawer.ModalDrawerController

/**
 * An opinionated TopAppBar that allows the user to open a modal navigation drawer via its
 * navigationIcon, and displays any MenuHost items.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigableTopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    modalDrawerController: ModalDrawerController = LocalModalDrawerController.current,
    menuHost: MenuHost = LocalMenuHost.current,
    scrollBehavior: TopAppBarScrollBehavior? = null,
) {
    TopAppBar(
        title = title,
        navigationIcon = { NavDrawerIconButton(modalDrawerController) },
        actions = { AnimatedTopAppBarMenuItems(menuHost = menuHost) },
        modifier = modifier,
        scrollBehavior = scrollBehavior,
    )
}