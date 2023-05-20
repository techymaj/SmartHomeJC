package com.example.smarthomejc

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smarthomejc.ui.pieces.RoutineClass
import com.example.smarthomejc.ui.pieces.RoutineItem
import kotlinx.coroutines.delay

@Composable
fun DynamicSvgContainer(routines: List<RoutineClass>?) {
    //val lazyListState = remember { mutableStateListOf <String>()}
            Box(
                contentAlignment = if(routines?.isEmpty() == true){ Alignment.Center }
                else{ Alignment.TopCenter },
                modifier = Modifier.fillMaxSize().padding(top = 10.dp)
            ) {
                if(routines?.isEmpty() == false){

                    LazyColumn() {
                        items(routines) { item ->
                            // Content of each item
                            RoutineItem(it = item)
                        }
                    }

                } else {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_update),
                            contentDescription = "Routines",
                            modifier = Modifier.size(100.dp),
                            tint = Color.Gray
                        )
                        Text(
                            text = "No Routines!",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray
                        )
                        Text("Click the '+' button below to get started")
                    }
                }
            }


}


