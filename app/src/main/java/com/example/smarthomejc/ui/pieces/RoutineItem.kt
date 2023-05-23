package com.example.smarthomejc.ui.pieces

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smarthomejc.R
import com.example.smarthomejc.lazyRoutines
import com.example.smarthomejc.ui.theme.SmartHomeJCTheme
//import com.google.gson.annotations.SerializedName

data class RoutineClass(
//    @SerializedName("name")
    var name:String,
//    @SerializedName("time")
    var time:String,
//    @SerializedName("isStarred")
    var isStarred:Boolean,
    var content:String
)

@Composable
fun RoutineItem(it:RoutineClass, index:Int) {
    Box(modifier = Modifier
        .padding(10.dp, 5.dp)
        .clip(RoundedCornerShape(15.dp))
        .background(Color.White)
        .border(2.dp, Color.Red, RoundedCornerShape(15.dp))
        .fillMaxWidth()
        .padding(6.dp)
        .padding(start = 12.dp)
    ){
        val fav = remember { mutableStateOf(it.isStarred) }
        val expanded = remember { mutableStateOf(false) }
        Row() {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .clickable { expanded.value = !expanded.value }
                    .animateContentSize()
            ) {
                Text(text = it.name, fontSize = 22.sp, color = Color.Black,
                    fontWeight = FontWeight.Bold, maxLines = if(expanded.value) Int.MAX_VALUE else 1)
                Text(text = it.content, fontSize = 16.sp,color = Color.Gray,
                    maxLines = if(expanded.value) Int.MAX_VALUE else 2)
                Text(text = it.time, fontSize = 10.sp, color = Color.DarkGray)
            }
            IconButton(onClick = { /*TODO*/
                fav.value = !fav.value
                lazyRoutines[index].isStarred = fav.value
                //saveRoutinesListToFile(filePath)
            }) {
                Icon(
                    tint = Color.Black,
                    painter = if(fav.value){
                        painterResource(id = R.drawable.round_star_filled)
                    }else{
                        painterResource(id = R.drawable.round_star_border)
                         },
                    contentDescription = null
                )
            }
        }
    }
}

@Preview
@Composable
fun A1(){
    SmartHomeJCTheme {
        RoutineItem(it = RoutineClass(name = "One", time = "10:28", isStarred = true,"Is The loneliest number"),0)
    }
}