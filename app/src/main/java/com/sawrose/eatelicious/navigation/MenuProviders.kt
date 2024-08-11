package com.sawrose.eatelicious.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BlurOn
import androidx.compose.runtime.Composable
import com.boswelja.menuprovider.MenuItem

@Composable
fun provideMenuProvider(): MenuItem =
    MenuItem(
        label = "Discover",
        imageVector = Icons.Filled.BlurOn,
        onClick = { /* Handle click */ },
        isImportant = true,
    )