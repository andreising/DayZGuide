package com.andreisingeleytsev.dayzguide.ui.screens.map_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.andreisingeleytsev.dayzguide.R
import com.andreisingeleytsev.dayzguide.ui.utils.DayZGuideFonts

@Composable
fun MapScreen(navHostController: NavHostController) {
    var scale by remember { mutableStateOf(1f) }
    var offset by remember { mutableStateOf(Offset(0f, 0f)) }
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .weight(12F)
                .pointerInput(Unit) {
                    detectTransformGestures { _, pan, zoom, _ ->
                        scale *= zoom
                        offset = if (scale > 1f) {
                            Offset(offset.x + pan.x * scale, offset.y + pan.y * scale)
                        } else {
                            Offset(0f, 0f)
                        }
                    }
                }
        ) {
            Image(
                modifier = Modifier
                    .graphicsLayer(
                        scaleX = maxOf(1f, minOf(3f, scale)),
                        scaleY = maxOf(1f, minOf(3f, scale)),
                        translationX = offset.x,
                        translationY = offset.y
                    )
                    .fillMaxSize(),
                contentDescription = null, painter = painterResource(id = R.drawable.map)
            )
        }
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
    }
}