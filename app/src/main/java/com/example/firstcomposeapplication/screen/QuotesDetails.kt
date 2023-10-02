package com.example.firstcomposeapplication.screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.firstcomposeapplication.models.QuotesModel


@Composable
fun QuotesDetails(quote: QuotesModel) {

    BackHandler {
        QuotesController.switchPage(null)
    }

    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1F)
            .background(
                Brush.sweepGradient(
                    colors = listOf(Color.White, Color.LightGray)
                )
            )
    ) {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier.padding(8.dp)) {
            Column( modifier = Modifier.padding(16.dp)) {
                Image(
                    imageVector = Icons.Filled.FormatQuote,
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(Color.Black),
                    alignment = Alignment.TopCenter,
                    modifier = Modifier
                        .size(48.dp)
                        .padding(8.dp)
                        .rotate(180F)
                )
                Text(text = quote.quote,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 0.dp, end = 0.dp, top= 0.dp, bottom = 8.dp)
                )
                Box(modifier = Modifier
                    .fillMaxWidth(.4f)
                    .background(Color.Gray)
                    .height(1.dp)
                )
                Text(text = quote.author,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Thin,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 0.dp, end = 0.dp, top= 8.dp, bottom = 0.dp)
                )
            }
        }
    }
}