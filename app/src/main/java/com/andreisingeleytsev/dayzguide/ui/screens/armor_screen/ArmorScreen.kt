package com.andreisingeleytsev.dayzguide.ui.screens.armor_screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

@Composable
fun ArmorScreen(navHostController: NavHostController) {
    val isFirstScreen = remember {
        mutableStateOf(true)
    }
    BackHandler {
        if (!isFirstScreen.value) navHostController.popBackStack()
        else isFirstScreen.value = true
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.3F)
                ), modifier = Modifier.clickable {
                    navHostController.popBackStack()
                }
            ) {
                Text(
                    text = stringResource(R.string.back).uppercase(),
                    modifier = Modifier.padding(vertical = 10.dp, horizontal = 5.dp),
                    style = TextStyle(
                        color = Color.White, fontFamily = DayZGuideFonts.font, fontSize = 20.sp
                    )
                )
            }
            if (isFirstScreen.value) Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.3F)
                ), modifier = Modifier.clickable {
                    isFirstScreen.value = false
                }
            ) {
                Text(
                    text = stringResource(R.string.next).uppercase(),
                    modifier = Modifier.padding(vertical = 10.dp, horizontal = 5.dp),
                    style = TextStyle(
                        color = Color.White, fontFamily = DayZGuideFonts.font, fontSize = 20.sp
                    )
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            if (isFirstScreen.value) Image(
                painter = painterResource(id = R.drawable.armor1),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            ) else {
                Image(
                    painter = painterResource(id = R.drawable.armor2),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )
            }
        }
    }
}
