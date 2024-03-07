package com.example.technical_assignment.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.technical_assignment.common.Constants.DEFAULT_IMG
import com.example.technical_assignment.common.loadPicture
import com.example.technical_assignment.models.Rating
import com.example.technical_assignment.models.StoreItem


@Composable
fun GridItemCard(
    item: StoreItem,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .fillMaxWidth()
            .requiredHeight(350.dp)
            .clickable(onClick = onClick)
            .padding(5.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Column {

            Card(
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredHeight(160.dp)
                    .padding(5.dp),
                colors = CardDefaults.cardColors(Color.White),
                elevation = CardDefaults.cardElevation(5.dp)
            ) {
                item.image.let { url ->
                    val image = loadPicture(
                        url = url,
                        defaultImage = DEFAULT_IMG
                    ).value
                    image?.let {
                        Image(
                            bitmap = it.asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .requiredHeight(150.dp),
                            contentScale = ContentScale.Fit
                        )
                    }
                }
            }
            Text(
                text = item.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                style = MaterialTheme.typography.labelLarge,
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Price: ${item.price}$",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowGridItemCard() {
    val rating = Rating(
        1,
        1.0
    )
    val item = StoreItem(
        "Men",
        "AAAAAAAA",
        1,
        DEFAULT_IMG.toString(),
        2.0,
        rating,
        "KING WEAR"
    )
    GridItemCard(item =item) {
    }
}