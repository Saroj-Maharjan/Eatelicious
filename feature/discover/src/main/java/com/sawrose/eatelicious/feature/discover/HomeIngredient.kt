package com.sawrose.eatelicious.feature.discover

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sawrose.eatelicious.core.data.local.entities.IngredientEntity

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeIngredient(
    ingredient: List<IngredientEntity>,
    onIngredientContent: () -> Unit,
    onIngredientSearch: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier.background(Color.DarkGray),
    ) {
        Text(
            "Search for ingredients",
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth(),
        )

        FlowRow {
            ingredient.forEach { ingredient ->
                IngredientItem(
                    ingredient = ingredient,
                    onIngredientSearch = onIngredientSearch,
                    modifier = Modifier.padding(8.dp),
                )
            }
        }

        Button(
            onClick = { onIngredientContent() },
            modifier = modifier
                .padding(vertical = 28.dp, horizontal = 16.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
            ),
            shape = MaterialTheme.shapes.small,
        ) {
            Text(
                "View all ingredients",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
            )
        }
    }
}
