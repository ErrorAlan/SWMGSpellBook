package com.example.swmgspellbook.homeScreen.data

import androidx.compose.runtime.Immutable
import com.example.swmgspellbook.R
import java.util.UUID

data class Quote(
    val quote: String,
    val quoteAuthor: String
)

@Immutable
data class  App(
    val name: String,
    val iconID: Int = R.drawable.ic_default,
    val appDescription: String = "this is an app that does things yippee!",
    val id: String = UUID.randomUUID().toString()
)