package com.example.swmgspellbook

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object NotesScreen : Screen("notes_screen")
    object MusicScreen : Screen("music_screen")
    object CalenderScreen : Screen("calender_screen")
    object SettingsScreen : Screen("settings_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}