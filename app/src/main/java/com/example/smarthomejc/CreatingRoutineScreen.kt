package com.example.smarthomejc

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun CreatingRoutineScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                onValueChange = {},
                label = {
                    Text(text = "Routine Name")
                }
            )
            Text(
                text = "When",
                fontSize = 23.sp,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 16.dp),
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray)
            ) {
                Text(
                    text = "Want this routine to run automatically? Add an event below",
                    fontSize = 15.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 16.dp),
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(modifier = Modifier.padding(horizontal = 100.dp))
                Text(
                    text = "Add Event",
                    fontSize = 23.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(all = 16.dp),
                )
                IconButton(
                    onClick = {
                        // Navigate to a new screen
                        navController.navigate("eventsScreen")
                    }) {
                    Icon(
                        modifier = Modifier.padding(top = 16.dp, end = 20.dp),
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Add Event"
                    )
                }
            }
            Text(
                text = "Run these actions",
                fontSize = 23.sp,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 16.dp),
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray)
            ) {
                Text(
                    text = "No actions. Tap below to add one.",
                    fontSize = 15.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 16.dp),
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(modifier = Modifier.padding(horizontal = 100.dp))
                Text(
                    text = "Add Event",
                    fontSize = 23.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(all = 16.dp),
                )
                IconButton(
                    onClick = {
                        // Navigate to a new screen
//                        navController.navigate("routine")
                    }) {
                    Icon(
                        modifier = Modifier.padding(top = 16.dp, end = 20.dp),
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Add Event"
                    )
                }
            }
            Text(
                text = "But only if",
                fontSize = 23.sp,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 16.dp),
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray)
            ) {
                Text(
                    text = "Add an event before adding conditions.",
                    fontSize = 15.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 16.dp),
                )
            }
        }
    }
}