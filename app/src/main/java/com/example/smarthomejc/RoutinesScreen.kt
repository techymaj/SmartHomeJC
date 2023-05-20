package com.example.smarthomejc

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.example.smarthomejc.ui.pieces.RoutineClass

var lazyRoutines = mutableListOf<RoutineClass>()
// committed
@Composable
fun RoutinesScreen() {
        DynamicSvgContainer(routines = lazyRoutines)
    }