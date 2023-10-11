package com.andreisingeleytsev.dayzguide.ui.screens.onboard_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.andreisingeleytsev.dayzguide.R
import com.andreisingeleytsev.dayzguide.ui.utils.DayZGuideFonts
import com.andreisingeleytsev.dayzguide.ui.utils.Routes


@Composable
fun OnBoardScreen(navHostController: NavHostController, onBoardFinished: () -> Unit) {
    val isFirstScreen = remember {
        mutableStateOf(true)
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Image(
            painter = painterResource(
                id = if (isFirstScreen.value) R.drawable.onboard_bg1
                else R.drawable.onboard_bg2
            ),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier

                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5F))
        )
        Column(
            modifier = Modifier
                .padding(28.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_title),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = stringResource(
                    if (isFirstScreen.value) R.string.onboard_title1
                    else R.string.onboard_title2
                ),
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(
                    color = Color.White, fontFamily = DayZGuideFonts.font, fontSize = 14.sp
                )
            )
            Spacer(modifier = Modifier.height(80.dp))
            Row(
                Modifier
                    .fillMaxWidth(), horizontalArrangement = Arrangement.End
            ) {
                IconButton(onClick = {
                    if (isFirstScreen.value) isFirstScreen.value = false
                    else {
                        onBoardFinished.invoke()
                        navHostController.popBackStack()
                        navHostController.navigate(Routes.HOME_SCREEN)
                    }
                }, modifier = Modifier.size(40.dp)) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_next),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        }
    }
}