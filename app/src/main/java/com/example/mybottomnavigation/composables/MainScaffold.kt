package com.example.mybottomnavigation.composables

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScaffold() {
    val navController = rememberNavController()
    Scaffold(
     topBar = { AppBar(title = "Apprendre BottomBar") },
     content = { HostController(navHostController = navController) },
     bottomBar = { BottomBar(navController = navController) }
    )
}