package com.example.firstcomposeapplication.screen

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.firstcomposeapplication.PageList
import com.example.firstcomposeapplication.models.QuotesModel
import com.google.gson.Gson

object QuotesController {

    var data = emptyArray<QuotesModel>()
    var currentPage = mutableStateOf(PageList.Listing)
    var currentQuotes: QuotesModel? = null
    var isLoadingData = mutableStateOf( false)


    fun loadQuotesData(context: Context){
            val inputStream = context.assets.open("quotesJson.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<QuotesModel>::class.java)
        isLoadingData.value = true
    }

    fun switchPage(quotes: QuotesModel?){
        currentQuotes = quotes
        if(currentPage.value == PageList.Listing){
            currentPage.value = PageList.Details
        }else{
            currentPage.value = PageList.Listing
        }
    }
}