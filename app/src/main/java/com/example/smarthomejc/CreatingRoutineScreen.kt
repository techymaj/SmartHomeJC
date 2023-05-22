package com.example.smarthomejc

import android.app.TimePickerDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.smarthomejc.ui.theme.SmartHomeJCTheme
import java.time.LocalTime

var currName:String = ""
var currTime:String = ""
var currCont:String = ""

@Composable
fun CreatingRoutineScreen(
    onTimeSelected: (LocalTime) -> Unit,
    //navController: NavController
) {
    val showTimePicker = remember { mutableStateOf(false) }
    val selectedTime = remember { mutableStateOf(LocalTime.now()) }

    val textState = remember { mutableStateOf(TextFieldValue()) }
    val textState1 = remember { mutableStateOf(TextFieldValue()) }
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
                value = textState.value,
                onValueChange = {
                    textState.value=it
                    currName = it.text },
                label = {
                    Text(text = "Routine Name")
                }
            )
            Text(
                text = "When $currTime",
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
                        showTimePicker.value = true
                        // Navigate to a new screen
                        //navController.navigate("eventsScreen")
                    }) {
                    Icon(
                        modifier = Modifier
                            .padding(top = 16.dp, end = 20.dp)
                            .clip(CircleShape)
                            .background(Color.Blue)
                            .size(35.dp),
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Add Event",

                    )
                }
                if (showTimePicker.value) {
                    TimePickerDialog(
                        initialTime = selectedTime.value,
                        onTimeSelected = {
                            selectedTime.value = it
                            showTimePicker.value = false
                            currTime = it.toString()
                            onTimeSelected(it)
                        },
                        onDismissRequest = { showTimePicker.value = false }
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
                        modifier = Modifier
                            .padding(top = 16.dp, end = 20.dp)
                            .clip(CircleShape)
                            .background(Color.Blue)
                            .size(35.dp),
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
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = textState1.value,
                onValueChange = {
                    textState1.value=it
                    currCont = it.text },
                label = {
                    Text(text = "Lengthy Description")
                }
            )
        }
    }
}

@Composable
fun TimePickerDialog(
    initialTime: LocalTime,
    onTimeSelected: (LocalTime) -> Unit,
    onDismissRequest: () -> Unit
) {
    //val dialogState by rememberDialogState(size = DialogSize(280.dp))

    Dialog(
        onDismissRequest = onDismissRequest,
        //state = dialogState
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            TimePicker { hour, minute ->
                onTimeSelected(initialTime.withHour(hour).withMinute(minute))}
            // Display and interact with the clock picker here

            Button(
                onClick = { onTimeSelected(initialTime) },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Select")
            }
        }
    }
}

@Composable
fun TimePicker(
    onTimeSelected: (hour: Int, minute: Int) -> Unit
) {
    val context = LocalContext.current
    val dialog = remember {
        TimePickerDialog(context, { _, hour, minute ->
            onTimeSelected(hour, minute)
            currTime = "$hour:$minute"
        }, 0, 0, true)
    }
    DisposableEffect(Unit) {
        dialog.show()
        onDispose { dialog.dismiss() }
    }
}

@Preview
@Composable
fun A1(){
    SmartHomeJCTheme {
        CreatingRoutineScreen(onTimeSelected = { })
    }
}