package com.sawrose.eatelicious.core.designsystem.navigation.drawer

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.sawrose.eatelicious.core.designsystem.navigation.LocalNavigationDrawerItems
import com.sawrose.eatelicious.core.designsystem.navigation.LocalNavigationMode
import com.sawrose.eatelicious.core.designsystem.navigation.LocalSelectedNavigationItem
import com.sawrose.eatelicious.core.designsystem.navigation.NavigationItem
import com.sawrose.eatelicious.core.designsystem.navigation.NavigationMode
import com.sawrose.eatelicious.core.designsystem.navigation.PrimaryNavigationMode
import kotlinx.coroutines.launch

/**
 * Displays either a [PermanentNavigationDrawer], or a [ModalNavigationDrawer], depending on the
 * state of [navigationMode].
 */
@Composable
fun NavigationDrawerLayout(
    drawerHeaderContent: @Composable () -> Unit,
    onNavigationItemClick: (NavigationItem) -> Unit,
    modifier: Modifier = Modifier,
    selectedItem: NavigationItem? = LocalSelectedNavigationItem.current,
    drawerItems: List<NavigationItem> = LocalNavigationDrawerItems.current,
    navigationMode: NavigationMode = LocalNavigationMode.current,
    content: @Composable () -> Unit
) {
    if (navigationMode.primaryNavigationMode == PrimaryNavigationMode.Permanent) {
        PermanentNavigationDrawer(
            drawerContent = {
                PermanentDrawerSheet {
                    NavigationDrawerContent(
                        items = drawerItems,
                        selectedItem = selectedItem,
                        onItemClick = onNavigationItemClick,
                        headerContent = drawerHeaderContent
                    )
                }
            },
            content = content,
            modifier = modifier
        )
    } else {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val controller = remember(drawerState) {
            ModalDrawerController(
                openDrawer = drawerState::open
            )
        }
        val coroutineScope = rememberCoroutineScope()
        CompositionLocalProvider(
            LocalModalDrawerController provides controller
        ) {
            ModalNavigationDrawer(
                drawerContent = {
                    ModalDrawerSheet(drawerState = drawerState) {
                        NavigationDrawerContent(
                            items = drawerItems,
                            selectedItem = selectedItem,
                            onItemClick = {
                                onNavigationItemClick(it)
                                coroutineScope.launch { drawerState.close() }
                            },
                            headerContent = drawerHeaderContent
                        )
                    }
                },
                drawerState = drawerState,
                content = content,
                modifier = modifier
            )
        }
    }
}