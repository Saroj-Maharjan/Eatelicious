package com.sawrose.eatelicious.feature.discover

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Bookmark
import androidx.compose.material.icons.rounded.BookmarkBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.sawrose.eatelicious.core.designsystem.component.EateliciousIconToggleButton
import com.sawrose.eatelicious.core.model.Recipe

@Composable
fun DiscoverCardResources(
    recipe: Recipe,
    handleEvent: (DiscoverEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 8.dp,
        ),
        onClick = {
            handleEvent(DiscoverEvent.OnRecipeClicked(recipe))
        },
        modifier = modifier
            .width(250.dp)
            .padding(8.dp),
    ) {
        Column {
            Box {
                DiscoverHeaderImage(imageUrl = recipe.image)
                BookmarkButton(
                    recipe.saved,
                    {},
                    Modifier.align(Alignment.TopEnd),
                )
            }
            Column(
                Modifier
                    .padding(16.dp),
            ) {
                Text(
                    text = recipe.name,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 1,
                    textAlign = TextAlign.Start,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .fillMaxWidth(),
                )
                Text(
                    "${recipe.servings} servings",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Light,
                    fontStyle = FontStyle.Normal,
                    maxLines = 1,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth(),
                )
            }
        }
    }
}

@Composable
fun DiscoverHeaderImage(
    imageUrl: String,
) {
    var isLoading by remember {
        mutableStateOf(true)
    }
    var isError by remember {
        mutableStateOf(false)
    }

    val imageLoader = rememberAsyncImagePainter(
        model = imageUrl,
        onState = { state ->
            isLoading = state is AsyncImagePainter.State.Loading
            isError = state is AsyncImagePainter.State.Error
        },
    )

    val isLocalInspection = LocalInspectionMode.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp),
        contentAlignment = Alignment.Center,
    ) {
        if (isLoading) {
            // Display a progress bar while loading
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(80.dp),
                color = MaterialTheme.colorScheme.tertiary,
            )
        }

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp),
            contentScale = ContentScale.Crop,
            painter = if (isError.not() && !isLocalInspection) {
                imageLoader
            } else {
                // Display a placeholder image if there is an error
                painterResource(id = R.drawable.placeholder)
            },
            contentDescription = null,
        )
    }
}

@Composable
fun BookmarkButton(
    isBookmarked: Boolean,
    onBookmarkClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    EateliciousIconToggleButton(
        checked = isBookmarked,
        onCheckedChange = { onBookmarkClicked() },
        modifier = modifier,
        icon = {
            Icon(
                imageVector = Icons.Rounded.BookmarkBorder,
                contentDescription = "Bookmark",
            )
        },
        checkedIcon = {
            Icon(
                imageVector = Icons.Rounded.Bookmark,
                contentDescription = "UnBookmark",
            )
        },
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun DiscoverRowPreview() {
    Box {
        DiscoverCardResources(
            recipe = Recipe(
                id = 1,
                name = "Recipe Name",
                image = "https://via.placeholder.com/150",
                spoonacularScore = 4.5,
                servings = 4,
                ingredientOriginalString = emptyList(),
                step = emptyList(),
                summary = "Recipe Summary",
            ),
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            handleEvent = {},
        )
    }
}
