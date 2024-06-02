package com.sawrose.eatelicious.feature.discover

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sawrose.eatelicious.core.data.local.entities.IngredientEntity

@Composable
fun IngredientItem(
    ingredient: IngredientEntity,
    onIngredientSearch: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        Modifier
            .clickable {
                onIngredientSearch(ingredient.ingredient)
            },
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .requiredSize(70.dp)
                .clip(CircleShape),
//                .background(android.graphics.Color.parseColor(ingredient.ingredient)),
        ) {
            DiscoverHeaderImage(imageUrl = "")
        }
        Text(
            text = ingredient.ingredient,
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(4.dp, 16.dp),
        )
    }
}