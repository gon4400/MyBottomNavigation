package com.example.mybottomnavigation.composables

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mybottomnavigation.datas.AppDatas

@Composable
fun BottomBar(navController: NavController) {

    fun onClick(route: String) {
        navController.navigate(route) {
            popUpTo(navController.graph.startDestinationRoute ?: return@navigate) {
                inclusive = false
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    NavigationBar(
        containerColor = NavigationBarDefaults.containerColor
    ) {
        // BackStackEntry pour connaître l'écran actuel
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        // Boucle à travers les éléments de navigation
        AppDatas().items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = { onClick(item.route) },
                icon = { Icon(imageVector = item.icon, contentDescription = item.name) },
                label = { Text(text = item.name) },
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Black,
                    unselectedIconColor = Color.Gray,
                    indicatorColor = Color.LightGray
                )
            )
        }
    }
}
