package com.coolapps.movieapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.coolapps.movieapplication.screens.home.HomeScreen
import com.coolapps.movieapplication.screens.details.DetailsScreen


@Composable
fun MovieNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = MovieScreens.HomeScreen.name){

        composable(MovieScreens.HomeScreen.name){
            //here we pass where this lead us
            HomeScreen(navController = navController)
        }
        //www.google.com/detail-screen/id=34
        composable(MovieScreens.DetailsScreen.name + "/{movie}",
        arguments = listOf(navArgument(name = "movie"){type = NavType.StringType})){
            backStackEntry ->

         DetailsScreen(navController = navController,
                backStackEntry.arguments?.getString("movie")
            )
        }
    }
}