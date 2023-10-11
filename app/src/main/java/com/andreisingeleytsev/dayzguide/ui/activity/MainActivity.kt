package com.andreisingeleytsev.dayzguide.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.andreisingeleytsev.dayzguide.ui.navigation.DayZGuideMainNavigationGraph
import com.andreisingeleytsev.dayzguide.ui.utils.Routes
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import com.andreisingeleytsev.dayzguide.R

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                if (!viewModel.isLoading.value) {
                    Box(modifier = Modifier.fillMaxSize()){
                        Image(painter = painterResource(id = R.drawable.main_bg), contentDescription = null, modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                        DayZGuideMainNavigationGraph(
                            startDestination = viewModel.startDestination.value!!
                        ){viewModel.onBoardFinished()}
                    }
                }
        }
    }
}