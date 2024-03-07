package com.example.technical_assignment.presentation.navigation

sealed class Screens(val route:String) {
    object MainScreen : Screens("mainScreen")
    object DetailScreen : Screens("detailScreen")

    fun withArgs(vararg args:String):String {
        return buildString {
            append(route)
            args.forEach {
                append("/$it")
            }
        }
    }
}