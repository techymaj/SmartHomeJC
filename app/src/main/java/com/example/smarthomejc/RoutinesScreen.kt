package com.example.smarthomejc

import androidx.compose.runtime.Composable
import com.example.smarthomejc.ui.pieces.RoutineClass
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

var lazyRoutines = mutableListOf<RoutineClass>()
// committed
@Composable
fun RoutinesScreen() {
    val file = File("rtinfo/routines.json")
    val gson = Gson()
    try{
        val json = file.readText()
        val listType = object : TypeToken<List<RoutineClass>>() {}.type
        lazyRoutines = gson.fromJson(json, listType)
    }catch (_: Throwable){}
    DynamicSvgContainer(routines = lazyRoutines)
}