package com.andreisingeleytsev.dayzguide.ui.screens.craft_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.andreisingeleytsev.dayzguide.R
import com.andreisingeleytsev.dayzguide.ui.utils.DayZGuideFonts

@Composable
fun CraftScreen(navHostController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.padding(24.dp)) {
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
        }
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Image(
                painter = painterResource(id = R.drawable.crafts),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
        }
    }
}