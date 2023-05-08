package com.example.smarthomejc

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ThingsScreen() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.CenterStart
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                imageVector = Icons.Default.Clear,
                contentDescription = "Things",
                modifier = Modifier.size(100.dp),
                tint = Color.Gray
            )
            Text(
                text = "No Things!",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )
            Text(text = "It looks like we didn't discover any devices.")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Try an option below")
            Spacer(modifier = Modifier.height(10.dp))
            Divider(
                color = Color.LightGray,
                thickness = 1.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    FloatingActionButton(
                        onClick = { /*TODO*/ },
                        backgroundColor = Color.Blue,
                        contentColor = Color.White,
                        modifier = Modifier.size(40.dp),
                        content = {
                            Icon(
                                imageVector = Icons.Filled.Search,
                                contentDescription = "Run discovery"
                            )
                        }
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Run discovery",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Blue,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    FloatingActionButton(
                        onClick = { /*TODO*/ },
                        backgroundColor = Color.Blue,
                        contentColor = Color.White,
                        modifier = Modifier.size(40.dp),
                        content = {
                            Icon(
                                imageVector = Icons.Filled.Add,
                                contentDescription = "Add a cloud account"
                            )
                        }
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Add a cloud account",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Blue,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    FloatingActionButton(
                        onClick = { /*TODO*/ },
                        backgroundColor = Color.Blue,
                        contentColor = Color.White,
                        modifier = Modifier.size(40.dp),
                        content = {
                            Icon(
                                imageVector = Icons.Filled.List,
                                contentDescription = "View our supported devices"
                            )
                        }
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "View our supported devices",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Blue,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    FloatingActionButton(
                        onClick = { /*TODO*/ },
                        backgroundColor = Color.Blue,
                        contentColor = Color.White,
                        modifier = Modifier.size(40.dp),
                        content = {
                            Icon(
                                imageVector = Icons.Filled.Email,
                                contentDescription = "Contact support"
                            )
                        }
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Contact support",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Blue,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }
        }
    }
}