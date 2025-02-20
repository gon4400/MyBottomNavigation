package com.example.mybottomnavigation.composables



import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mybottomnavigation.datas.AppDatas
import com.example.mybottomnavigation.model.ItemNav

@Composable
fun HostController(navHostController: NavHostController) {
    val items = remember { AppDatas().items } // Optimisation pour éviter les recréations

    NavHost(
        navController = navHostController,
        startDestination = ItemNav.First.route
    ) {
        items.forEach { item ->
            composable(route = item.route) { // Assurez-vous que "composable" est bien importé
                SelectedScreen(item = item)
            }
        }
    }
}
