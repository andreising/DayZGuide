package com.andreisingeleytsev.dayzguide.ui.navigation


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.andreisingeleytsev.dayzguide.ui.screens.armor_screen.ArmorScreen
import com.andreisingeleytsev.dayzguide.ui.screens.constructions_screens.ConstructionScreen
import com.andreisingeleytsev.dayzguide.ui.screens.craft_screen.CraftScreen
import com.andreisingeleytsev.dayzguide.ui.screens.home_screen.HomeScreen
import com.andreisingeleytsev.dayzguide.ui.screens.map_screen.MapScreen
import com.andreisingeleytsev.dayzguide.ui.screens.meal_screen.MealScreen
import com.andreisingeleytsev.dayzguide.ui.screens.onboard_screen.OnBoardScreen
import com.andreisingeleytsev.dayzguide.ui.utils.Routes


@Composable
fun DayZGuideMainNavigationGraph(
    startDestination: String, onBoardFinished: ()-> Unit
) {
    val navHostController = rememberNavController()
    NavHost(navController = navHostController, startDestination = startDestination,
        modifier = Modifier.background(Color.Transparent)) {

        composable(Routes.ONBOARDING_SCREEN){
            OnBoardScreen(navHostController){onBoardFinished.invoke()}
        }
        composable(Routes.HOME_SCREEN) {
            HomeScreen(navHostController)
        }
        composable(Routes.CRAFTS_SCREEN) {
            CraftScreen(navHostController)
        }
        composable(Routes.CONSTRUCTION_SCREEN) {
            ConstructionScreen(navHostController)
        }
        composable(Routes.MEAL_SCREEN) {
            MealScreen(navHostController)
        }
        composable(Routes.ARMOR_SCREEN) {
            ArmorScreen(navHostController)
        }
        composable(Routes.MAP_SCREEN) {
            MapScreen(navHostController)
        }
    }
}
