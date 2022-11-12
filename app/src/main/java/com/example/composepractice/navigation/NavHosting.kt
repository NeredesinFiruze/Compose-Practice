package com.example.composepractice.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composepractice.presentation.HomeScreen

@Composable
fun NavHosting(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Screen.Home.route){

        composable(Screen.Home.route){
            HomeScreen()
        }
    }
}