package com.example.firstcomposeapplication.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.firstcomposeapplication.models.QuotesModel




@Composable
fun QuotesCardList(quotes: Array<QuotesModel>, onClick: (quote: QuotesModel) -> Unit) {
    LazyColumn {
        items(quotes) { it ->
            QuotesCardItem(quote = it, onClick)
        }
    }
}


@Composable
fun QuotesCardItem(quote: QuotesModel, onClick: (quote: QuotesModel) -> Unit) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .padding(8.dp)
            .clickable { onClick(quote) }
    ) {
        Row(modifier = Modifier.padding(10.dp)) {
            Image(
                imageVector = Icons.Filled.FormatQuote,
                contentDescription = "",
                colorFilter = ColorFilter.tint(Color.White),
                alignment = Alignment.TopCenter,
                modifier = Modifier
                    .size(48.dp)
                    .padding(8.dp)
                    .rotate(180F)
                    .background(Color.Black)
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Column(modifier = Modifier.weight(1F)) {
                Text(
                    text = quote.quote,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 0.dp, end = 0.dp, top = 0.dp, bottom = 8.dp)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth(.4f)
                        .background(Color.LightGray)
                        .height(1.dp)
                )
                Text(
                    text = quote.author,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Thin,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 0.dp, end = 0.dp, top = 8.dp, bottom = 0.dp)
                )
            }
        }
    }
}


