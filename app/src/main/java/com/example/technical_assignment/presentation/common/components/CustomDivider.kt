package com.example.technical_assignment.presentation.common.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun CustomDivider(){
    Divider(thickness = 1.dp, color = Color.Black, modifier = Modifier.padding(top = 5.dp))

}