package com.sawrose.eatelicious.core.designsystem.navigation.navrail

import androidx.compose.material3.NavigationRail
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sawrose.eatelicious.core.designsystem.navigation.NavigationItem
import com.sawrose.eatelicious.core.designsystem.navigation.NavigationRailItem
import com.sawrose.eatelicious.core.designsystem.navigation.drawer.LocalModalDrawerController
import com.sawrose.eatelicious.core.designsystem.navigation.drawer.ModalDrawerController
import com.sawrose.eatelicious.core.designsystem.navigation.topbars.NavDrawerIconButton

@Composable
internal fun StartNavRail(
    items: List<NavigationItem>,
    selectedItem: NavigationItem?,
    onItemClick: (NavigationItem) -> Unit,
    modifier: Modifier = Modifier,
    drawerController: ModalDrawerController = LocalModalDrawerController.current,
) {
    NavigationRail(
        header = {
            NavDrawerIconButton(drawerController)
        },
        modifier = modifier,
    ) {
        items.forEach { item ->
            NavigationRailItem(
                item = item,
                selected = item == selectedItem,
                onClick = { onItemClick(item) },
            )
        }
    }
}
