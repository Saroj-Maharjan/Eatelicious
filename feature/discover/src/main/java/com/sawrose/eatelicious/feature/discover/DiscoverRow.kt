package com.sawrose.eatelicious.feature.discover

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sawrose.eatelicious.core.model.Recipe

@Composable
fun DiscoverRow(
    recipe: Recipe,
    onRecipeClicked: (Recipe) -> Unit,
    handleEvent: (DiscoverEvent) -> Unit,
    modifier: Modifier = Modifier,
) {

    Card(
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 4.dp
        ),
        onClick = {
            onRecipeClicked(recipe)
        },
        modifier = modifier
            .padding(8.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(8.dp)
        ) {
            AsyncImage(
                model = recipe.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(100.dp)
                    .height(150.dp)
                    .aspectRatio(1f)
            )
            Text(
                text = recipe.name,
                maxLines = 1,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
            )
            Text(text = "✦ ${recipe.spoonacularScore} stars")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DiscoverRowPreview() {
    Box {
        DiscoverRow(
            recipe = Recipe(
                id = 1,
                name = "Recipe Name",
                image = "https://via.placeholder.com/150",
                spoonacularScore = 4.5,
                servings = 4,
                ingredientOriginalString = emptyList(),
                step = emptyList(),
                summary = "Recipe Summary"
            ),
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            handleEvent = {},
            onRecipeClicked = {}
        )
    }
}