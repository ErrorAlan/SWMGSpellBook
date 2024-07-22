package com.example.swmgspellbook

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object DetailScreen : Screen("notes_screen")
    object MusicScreen : Screen("music_screen")
    object CalenderScreen : Screen("calender_screen")
    object SettingsScreen : Screen("settings_screen")
}