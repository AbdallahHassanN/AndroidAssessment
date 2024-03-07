package com.example.technical_assignment.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.technical_assignment.common.Constants.DEFAULT_IMG
import com.example.technical_assignment.common.loadPicture
import com.example.technical_assignment.models.StoreItem

@Composable
fun StoreItemCard(
    storeItem: StoreItem,
    onClick: () -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                bottom = 6.dp,
                top = 6.dp
            )
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row {
            storeItem.image.let { url ->
                val image = loadPicture(
                    url = url,
                    defaultImage = DEFAULT_IMG
                ).value
                image?.let { img ->
                    Image(
                        bitmap = img.asImageBitmap(),
                        contentDescription = "storeItemImage",
                        modifier = Modifier
                            .width(150.dp)
                            .height(150.dp)
                            .padding(start = 10.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }
            Column {
                Text(
                    text = storeItem.title,
                    modifier = Modifier
                        .wrapContentWidth(Alignment.Start)
                        .padding(5.dp),
                    style = MaterialTheme.typography.labelLarge,
                )
                Text(
                    text = "Rated : ${storeItem.rating.rate} by ${storeItem.rating.count}",
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .wrapContentWidth(Alignment.End),
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
    }
}