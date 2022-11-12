package com.example.composepractice.navigation

sealed class Screen(val route: String){

    object Home: Screen("home_screen")
}
