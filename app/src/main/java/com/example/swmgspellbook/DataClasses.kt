package com.example.swmgspellbook

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource

data class Quote(val quote: String, val quoteAuthor: String)

data class  App(val name: String, val iconID: Int = R.drawable.ic_default, val appDescription: String = "this is an app that does things yippee!")