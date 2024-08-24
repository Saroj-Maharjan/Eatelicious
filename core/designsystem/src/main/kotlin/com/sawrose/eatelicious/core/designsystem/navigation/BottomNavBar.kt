package com.sawrose.eatelicious.core.designsystem.navigation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun BottomNavBar(
    items: List<NavigationItem>,
    selectedItem: NavigationItem?,
    onItemClick: (NavigationItem) -> Unit,
    modifier: Modifier = Modifier,
) {
    NavigationBar(modifier = modifier) {
        Spacer(Modifier.width(8.dp))
        items.forEach { item ->
            BottomNavigationItem(
                item = item,
                selected = item == selectedItem,
                onClick = { onItemClick(item) },
            )
        }
        Spacer(Modifier.width(8.dp))
    }
}
