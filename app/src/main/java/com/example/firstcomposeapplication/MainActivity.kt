package com.example.firstcomposeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstcomposeapplication.models.QuotesModel
import com.example.firstcomposeapplication.screen.QuotesController
import com.example.firstcomposeapplication.screen.QuotesDetails
import com.example.firstcomposeapplication.screen.QuotesListScreen
import com.example.firstcomposeapplication.ui.theme.FirstComposeApplicationTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            delay(2000)
            QuotesController.loadQuotesData(applicationContext)
        }
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    if(QuotesController.isLoadingData.value){
        if(QuotesController.currentPage.value == PageList.Listing){
            QuotesListScreen(quotes = QuotesController.data) {
                QuotesController.switchPage(it)
            }
        }else{
            QuotesController.currentQuotes?.let { QuotesDetails(quote = it) }
        }
    }else{
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize(1f)) {
            Text(
                text = "Loading...",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium,
                color = Color.Black,
            )
        }
    }
}

enum class PageList {
    Listing,
    Details
}
