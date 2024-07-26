package com.example.swmgspellbook

import android.inputmethodservice.Keyboard.Row
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.swmgspellbook.ui.theme.Whitebg


@Composable
fun HomeScreen(todaysQuote: Quote, app: App) {
    val appList = Applist()
    val getAllApps = appList.getAllApps()

    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            quote = todaysQuote,
            modifier = Modifier
        )
        Divider(thickness = Dp.Hairline)

        LazyColumn (
            contentPadding = PaddingValues(all = 10.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
            ){
            items(items = getAllApps) { app ->
                AppButton(targetApp = app)
            }
        }



        AppSelection(
            app = app,
            modifier = Modifier
                .weight(1f)

        )
    }
}

@Composable
fun TopBar(
    quote: Quote,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .padding(start = 13.dp, end = 15.dp, top = 10.dp, bottom = 10.dp)

    ) {
        Text(
            modifier = Modifier.weight(8.5f),
            text = "Loza's Apps",
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.DarkGray
        )
        Spacer(modifier = Modifier.weight(.5f))

        IconButton(
            colors = IconButtonDefaults.outlinedIconButtonColors(),
            onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_dotmenu),
                contentDescription = "dot menu",
                tint = Color.DarkGray,
                modifier = Modifier
                    .size(18.dp)
                    .weight(.7f)
            )
        }


    }
}

@Composable
fun Quote(
    quote: Quote,
    modifier: Modifier = Modifier
) {
    Column(

        modifier = modifier
    ) {
        Text(
            text = "\"$quote.quote\"",
            maxLines = 2,
            //minLines = 2,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
        )
        Text(
            text = " - $quote.quoteAuthor",
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp,
        )
    }
}

//could add list of app objects and have lazy column or something but for now 4 butttons :)
@Composable
fun AppSelection(
    app: App,
    modifier: Modifier = Modifier
) {
    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier

    ) {
        AppButton(
            modifier = Modifier.fillMaxWidth(),
            targetApp = app,
        )

    }
}

@Composable
fun AppButton(
    targetApp: App,
    modifier: Modifier = Modifier,

    ) {
    val colorStops = arrayOf(
        0.0f to Color.LightGray,
        0.3f to Whitebg,
        1f to Whitebg
    )
    val gradient =Brush.horizontalGradient(
        colorStops = colorStops
    )
    Button(
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
        contentPadding = PaddingValues(0.dp),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .height(120.dp),
        onClick = { /*TODO*/ }
    ) {
        Box(modifier = Modifier.background(gradient)) {
            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    alignment = Alignment.CenterStart,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight(),
                    painter = painterResource(targetApp.iconID), contentDescription = "a"
                )
                Divider(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                        .background(Color.LightGray)
                )
                Column(
                    modifier = Modifier.padding(start = 7.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(top = 2.dp),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp,
                        color = Color.DarkGray,
                        text = "${targetApp.name}"
                    )
                    Text(
                        modifier = Modifier.padding(start = 2.dp),
                        fontWeight = FontWeight.Light,
                        color = Color.DarkGray,
                        text = "${targetApp.appDescription}"
                    )
                }
            }
        }
    }
}

