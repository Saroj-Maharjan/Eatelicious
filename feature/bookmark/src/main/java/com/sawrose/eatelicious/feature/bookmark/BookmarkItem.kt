package com.sawrose.eatelicious.feature.bookmark

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.sawrose.eatelicious.commons.view.AsyncImage
import com.sawrose.eatelicious.core.model.Recipe

@Composable
fun BookmarkItem(
    modifier: Modifier = Modifier,
    recipe: Recipe,
) {
    Box(
        modifier
            .size(250.dp, 150.dp),
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp,
            ),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                AsyncImage(
                    model = recipe.image,
                    requestBuilder = { crossfade(true) },
                    contentDescription = "Cuisine image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                )
//                BookMarkButton(
//                    modifier = Modifier
//                        .align(Alignment.TopEnd)
//                        .padding(8.dp),
//                    backgroundColor = colorResource(id = R.color.black_alpha),
//                    onBookMark = {
//                        onBookMark(recipe)
//                    },
//                    selected = recipe.saved,
//                )
            }
        }
    }
}
