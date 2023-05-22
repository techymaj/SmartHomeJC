package com.example.smarthomejc

import androidx.compose.runtime.Composable
import com.example.smarthomejc.ui.pieces.RoutineClass

var lazyRoutines = mutableListOf<RoutineClass>()
//const val filePath = "rtinfo/routines.json"
// committed
@Composable
fun RoutinesScreen() {
//    try{
//        updateRoutinesListFromFile(filePath)
//    }catch (_: Throwable){}
    DynamicSvgContainer(routines = lazyRoutines)
}

/*
fun saveRoutinesListToFile(path:String) {
    try{
        val gson = Gson()
        val json2 = gson.toJson(lazyRoutines)
        val outputStream = FileOutputStream(path)
        outputStream.write(json2.toByteArray())
        outputStream.close()}
    catch(_:Throwable){
        File(path).createNewFile()
        saveRoutinesListToFile(path)
    }
}
fun updateRoutinesListFromFile(path:String){
    try{
        val gson = Gson()
        val json = File(path).readText()
        val listType = object : TypeToken<List<RoutineClass>>() {}.type
        lazyRoutines = gson.fromJson(json, listType)
    }catch(_:Throwable){
        saveRoutinesListToFile(path)
    }
}

 */