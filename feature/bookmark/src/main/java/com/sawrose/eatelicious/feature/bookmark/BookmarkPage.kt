package com.sawrose.eatelicious.feature.bookmark

import androidx.activity.compose.ReportDrawnWhen
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.HideImage
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sawrose.eatelicious.core.designsystem.component.EmptyView
import com.sawrose.eatelicious.core.designsystem.component.ScreenBackground

@Composable
fun BookmarkPage(
    modifier: Modifier = Modifier,
    uiState: BookmarkUIState,
) {
    ReportDrawnWhen {
        uiState !is BookmarkUIState.Loading
    }

    when (uiState) {
        BookmarkUIState.Loading -> {

        }

        is BookmarkUIState.Error -> {

        }

        is BookmarkUIState.Success -> {

            BookmarkScreen(
                bookmarks = uiState.bookmarks,
            )

            AnimatedVisibility(
                visible = uiState.bookmarks.isEmpty(),
            ) {
                EmptyView(
                    title = "No Bookmarks",
                    message = "You have not bookmarked any recipes yet",
                    imageVector = Icons.Filled.HideImage,
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding(),
                )
            }
        }
    }
}

@Composable
fun BookmarkScreen(
    modifier: Modifier = Modifier,
    bookmarks: List<String>,
) {
    ScreenBackground(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
    ) {
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(bookmarks) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                        .padding(16.dp),
                ) {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.headlineMedium,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(Alignment.Center),
                    )
                }
            }
        }
    }
}