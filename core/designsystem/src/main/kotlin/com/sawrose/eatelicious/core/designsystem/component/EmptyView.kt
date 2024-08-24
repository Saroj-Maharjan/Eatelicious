package com.sawrose.eatelicious.core.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.HourglassEmpty
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.unit.dp

@Composable
fun EmptyView(
    modifier: Modifier = Modifier,
    title: String,
    message: String,
    imageVector: ImageVector? = null,
) {
    ElevatedCard(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
    ) {
        imageVector?.let {
            Image(
                it,
                contentDescription = "Empty View Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            )
        }
        Text(
            text = title,
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
        )

        Text(
            text = message,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
        )
    }
}

@PreviewDynamicColors
@Composable
private fun EmptyViewPreview() {
    Box {
        EmptyView(
            imageVector = Icons.Filled.HourglassEmpty,
            title = "No bookmarks",
            message = "You haven't bookmarked any recipes yet",
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
        )
    }
}
