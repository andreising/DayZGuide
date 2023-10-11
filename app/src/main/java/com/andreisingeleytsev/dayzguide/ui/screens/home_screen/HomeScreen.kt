package com.andreisingeleytsev.dayzguide.ui.screens.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import com.andreisingeleytsev.dayzguide.ui.utils.Routes

@Composable
fun HomeScreen(navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_title),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Spacer(modifier = Modifier.height(10.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navHostController.navigate(Routes.CRAFTS_SCREEN)
                },
            shape = RoundedCornerShape(30.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White.copy(alpha = 0.15F)
            )
        ) {
            Text(
                text = stringResource(R.string.crafts).uppercase(),
                modifier = Modifier
                    .padding(vertical = 30.dp)
                    .fillMaxWidth(),
                style = TextStyle(
                    color = Color.White, fontFamily = DayZGuideFonts.font, fontSize = 40.sp,
                    textAlign = TextAlign.Center
                )
            )
        }
        Card(
            modifier = Modifier.fillMaxWidth()
                .clickable {
                    navHostController.navigate(Routes.CONSTRUCTION_SCREEN)
                },
            shape = RoundedCornerShape(30.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White.copy(alpha = 0.15F)
            )
        ) {
            Text(
                text = stringResource(R.string.constructions).uppercase(),
                modifier = Modifier
                    .padding(vertical = 30.dp)
                    .fillMaxWidth(),
                style = TextStyle(
                    color = Color.White, fontFamily = DayZGuideFonts.font, fontSize = 40.sp,
                    textAlign = TextAlign.Center
                )
            )
        }
        Card(
            modifier = Modifier.fillMaxWidth()
                .clickable {
                    navHostController.navigate(Routes.MEAL_SCREEN)
                },
            shape = RoundedCornerShape(30.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White.copy(alpha = 0.15F)
            )
        ) {
            Text(
                text = stringResource(R.string.meal).uppercase(),
                modifier = Modifier
                    .padding(vertical = 30.dp)
                    .fillMaxWidth(),
                style = TextStyle(
                    color = Color.White, fontFamily = DayZGuideFonts.font, fontSize = 40.sp,
                    textAlign = TextAlign.Center
                )
            )
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Card(
                modifier = Modifier.size(100.dp)
                    .clickable {
                        navHostController.navigate(Routes.ARMOR_SCREEN)
                    },
                shape = RoundedCornerShape(30.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.15F)
                )
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(R.string.armor).uppercase(),
                        modifier = Modifier
                            .fillMaxWidth(),
                        style = TextStyle(
                            color = Color.White,
                            fontFamily = DayZGuideFonts.font,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        )
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.icon_armor),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
            Card(
                modifier = Modifier.size(100.dp)
                    .clickable {
                        navHostController.navigate(Routes.MAP_SCREEN)
                    },
                shape = RoundedCornerShape(30.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.15F)
                )
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(R.string.map).uppercase(),
                        modifier = Modifier
                            .fillMaxWidth(),
                        style = TextStyle(
                            color = Color.White,
                            fontFamily = DayZGuideFonts.font,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        )
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.icon_map),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        }
    }
}