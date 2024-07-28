package com.example.swmgspellbook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.example.swmgspellbook.homeScreen.data.App
import com.example.swmgspellbook.homeScreen.data.Quote
import com.example.swmgspellbook.homeScreen.presentation.HomeScreen

//import kotlinx.serialization.Serializer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val todaysQuote = Quote(quote = "The time will pass anyways", quoteAuthor = "Me")
            val theapp = App(name = "Music")
            Box(modifier = Modifier.fillMaxSize()) {
                HomeScreen()
            }

        }
    }
}

