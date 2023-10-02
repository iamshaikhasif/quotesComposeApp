package com.example.firstcomposeapplication.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.firstcomposeapplication.models.QuotesModel

@Composable
fun QuotesListScreen(quotes: Array<QuotesModel>, onClick: (quote: QuotesModel) -> Unit) {
    Column {
        Text(
            text = "Quotes App",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(8.dp, 24.dp)
                .fillMaxWidth(1F),
            style = MaterialTheme.typography.headlineLarge
        )
        QuotesCardList(quotes = quotes, onClick)
    }
}