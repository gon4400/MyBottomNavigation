package com.example.mybottomnavigation.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector


sealed class ItemNav(
    val name: String,
    val icon: ImageVector,
    val route: String,
    val color: Color
) {
    object First: ItemNav("Accueil", Icons.Default.Home, "Home", Color.Blue)
    object Second: ItemNav("A propos", Icons.Default.Person, "About", Color.Red)
    object Third: ItemNav("Portfolio", Icons.Default.Star, "Portfolio", Color.Green)
    object Fourth: ItemNav("Contact", Icons.Default.Email, "Contact", Color.Magenta)
}
