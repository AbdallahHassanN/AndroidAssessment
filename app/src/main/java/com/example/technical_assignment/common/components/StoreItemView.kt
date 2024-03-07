package com.example.technical_assignment.common.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.BackdropScaffold
import androidx.compose.material.BackdropValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.rememberBackdropScaffoldState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.technical_assignment.common.Constants.DEFAULT_IMG
import com.example.technical_assignment.common.loadPicture
@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("SuspiciousIndentation")
@Composable
fun StoreItemView(
    title: String,
    desc: String,
    price: String,
    rating: String,
    img: String,
    count: String,
    navController: NavController
) {
    val scaffoldState = rememberBackdropScaffoldState(BackdropValue.Revealed)

    BackdropScaffold(
        scaffoldState = scaffoldState,
        appBar = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
        },
        backLayerContent = {
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .background(Color.White)
            ) {
                img.let { imgUrl ->
                    val image = loadPicture(url = imgUrl, defaultImage = DEFAULT_IMG)
                        .value
                    image?.let { img ->
                        Image(
                            bitmap = img.asImageBitmap(), contentDescription = "Item Image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .requiredHeight(260.dp)
                                .padding(top = 10.dp),
                            contentScale = ContentScale.Fit
                        )
                    }
                }
            }
        },
        frontLayerContent = {
            Column {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(10.dp),
                ) {
                    Text(
                        text = title,
                        modifier = Modifier
                            .fillMaxWidth(0.7f)
                            .padding(5.dp),
                        style = MaterialTheme.typography.titleMedium,
                        softWrap = true
                    )
                    Text(
                        text = "Rated: $rating by $count users",
                        modifier = Modifier
                            .fillMaxWidth(0.7f)
                            .padding(5.dp),
                        style = MaterialTheme.typography.titleMedium,
                        softWrap = true
                    )
                }
                CustomDivider()

                Row {
                    Text(
                        text = desc,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        style = MaterialTheme.typography.labelLarge,
                        softWrap = true
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                ) {
                    Text(
                        text = "Buy Now: $price$",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        style = MaterialTheme.typography.labelLarge,
                        softWrap = true
                    )
                }
            }
        },
        backLayerBackgroundColor = Color.White
    )
}
@Preview(showBackground = true)
@Composable
fun ShowGridItemView() {
    val navController = rememberNavController()
    StoreItemView(
        title = "KING WEAR",
        desc = "KING WEAR KING WEAR KING WEAR KING WEAR",
        price = "20.",
        rating = "44",
        img = DEFAULT_IMG.toString(),
        count = "33",
        navController = navController
    )
}
