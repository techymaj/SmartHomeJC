package com.example.smarthomejc

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun SettingsScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            CustomListTitle(title = "User Settings")
            CustomListItem(
                title = "Majaliwa",
                subtitle = "wilfriedmajaliwa@gmail.com",
                itemIcon = Icons.Filled.AccountCircle
            )
            CustomListTitle(title = "Home Settings")
            CustomListItem(
                title = "Accounts & Hubs",
                itemIcon = Icons.Filled.Person
            )
            Divider()
            CustomListItem(
                title = "Clients",
                itemIcon = Icons.Rounded.Phone
            )
            Divider()
            CustomListItem(
                title = "Locations",
                itemIcon = Icons.Filled.LocationOn
            )
            CustomListTitle(title = "Voice")
            CustomListItem(
                title = "Voice Assistant",
                itemIcon = Icons.Filled.Phone
            )
            CustomListTitle(title = "App Permissions")
            CustomListItem(
                title = "Notifications & Permissions",
                itemIcon = Icons.Filled.Settings,
                color = Color.Black
            )
        }
    }
}