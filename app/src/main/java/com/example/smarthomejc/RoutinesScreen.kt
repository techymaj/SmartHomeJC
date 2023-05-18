package com.example.smarthomejc

import androidx.compose.runtime.Composable

// committed
@Composable
fun RoutinesScreen() {
//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    )
//    fun MyScreen() {
        val routines = listOf(
            "many" ,
            "men" ,
            "wish"
        )

        DynamicSvgContainer(routines = routines)
    }