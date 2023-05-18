package com.example.smarthomejc


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.smarthomejc.ui.theme.SmartHomeJCTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmartHomeJCTheme {
                val navController = rememberNavController()
                val systemUiController = rememberSystemUiController()
                SideEffect {
                    systemUiController.setStatusBarColor(
                        color = Color.Red,
                        darkIcons = false
                    )
                }
                var routeHere = remember{ mutableStateOf("favorites")}
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(
                            items = listOf(
                                BottomNavItem("Favorites", "favorites", Icons.Rounded.Star),
                                BottomNavItem("Things", "things", Icons.Filled.Search),
                                BottomNavItem(
                                    "Routines",
                                    "routines",
                                    painter = painterResource(id = R.drawable.ic_update)
                                ),
                                BottomNavItem(
                                    "Ideas",
                                    "ideas",
                                    painter = if (navController.currentBackStackEntryAsState().value?.destination?.id == 4) painterResource(
                                        id = R.drawable.ic_bulb_filled
                                    ) else painterResource(id = R.drawable.ic_bulb)
                                ),
                                BottomNavItem("Settings", "settings", Icons.Filled.Settings),
                            ),
                            navController = navController,
                            onItemClick = {
                                // Handle item click
                                navController.navigate(it.route)
                                routeHere.value = navController.currentBackStackEntry?.destination?.route!!
                            }
                        )
                    },
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    text = "My Smart Home",
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.fillMaxWidth(),
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            },
                            backgroundColor = Color.Red,
                            elevation = 5.dp,
                            contentColor = Color.White,
                            actions = {
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        imageVector = Icons.Filled.Edit,
                                        contentDescription = "Edit"
                                    )
                                }
/*                                if (navController.currentBackStackEntry?.destination?.route == "favorites") {
//                                    IconButton(onClick = { /*TODO*/ }) {
//                                        Icon(
//                                            imageVector = Icons.Filled.Edit,
//                                            contentDescription = "Edit"
//                                        )
//                                    }
//                                } else if (navController.currentBackStackEntry?.destination?.route == "things") {
//                                    IconButton(onClick = { /*TODO*/ }) {
//                                        Icon(
//                                            imageVector = Icons.Filled.Search,
//                                            contentDescription = "Search"
//                                        )
//                                    }
//                                    Spacer(modifier = Modifier.width(10.dp))
//                                    IconButton(onClick = { /*TODO*/ }) {
//                                        Icon(
//                                            imageVector = Icons.Filled.Menu,
//                                            contentDescription = "Menu"
//                                        )
//                                    }
//                                }*/
                            }
                        )
                    },
                    floatingActionButton = {
                        if(routeHere.value != "things" && routeHere.value != "settings"){
                            FloatingActionButton(
                                onClick = {
                                    // Navigate to new screen
                                    if (routeHere.value == "favorites"){
                                        navController.navigate("routines")
                                    }
                                    if (routeHere.value == "routines"){
                                        navController.navigate("createRoutine")
                                    }
                                    if (routeHere.value == "ideas"){
                                        //implement
                                    }
                                },
                                backgroundColor = Color.Blue,
                                contentColor = Color.White,
                                content = {
                                    Icon(
                                        imageVector = Icons.Filled.Add,
                                        contentDescription = "Add"
                                    )
                                }
                            )
                        }
                    },

                    ) {
                    Navigation(navController = navController)
                }
            }
        }
    }
}


@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.White,
        elevation = 5.dp
    ) {
        items.forEach { item ->
            val selected = backStackEntry.value?.destination?.route == item.route
            BottomNavigationItem(
                icon = {
                    if (item.icon != null) {
                        Icon(
                            imageVector = item.icon!!,
                            contentDescription = item.name
                        )
                    } else {
                        Icon(
                            painter = item.painter!!,
                            contentDescription = item.name
                        )
                    }
                },
                label = { Text(item.name, maxLines = 1, style = androidx.compose.ui.text.TextStyle(fontSize = 10.sp)) },
                selected = selected,
                selectedContentColor = Color.Red,
                unselectedContentColor = Color.Black,
                onClick = {
                    onItemClick(item)
                    navController.navigate(item.route)
                }
            )
        }
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "favorites"
    ) {

        composable("favorites") {
            // Home screen
            HomeScreen()
        }
        composable("things") {
            // Things screen
            ThingsScreen()

        }
        composable("routines") {
            // Routines screen
            RoutinesScreen()
        }
        composable("ideas") {
            // Ideas screen
            IdeasScreen()
        }
        composable("settings") {
            // Settings screen
            SettingsScreen()
        }
        composable("createRoutine") {
            // Create Routine screen
            CreateRoutineScreen(
                navController = navController
            )
        }
        composable("routine") {
            // Create Routine screen
            CreatingRoutineScreen(
                navController = navController
            )
        }
        composable("eventsScreen") {
            // Create Routine screen
            AddingEventScreen(
                navController = navController
            )
        }
    }
}

@Composable
fun CustomListTitle(title: String) {
    Text(
        text = title,
        color = Color.DarkGray,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(all = 12.dp),
    )
}

@Composable
fun CustomListItem(
    title: String,
    subtitle: String? = null,
    itemIcon: ImageVector,
    color: Color = Color.Red
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 16.dp)
    ) {
        Icon(
            modifier = Modifier.align(Alignment.CenterVertically),
            imageVector = itemIcon,
            contentDescription = "Icon",
            tint = color
        )
        Column(modifier = Modifier.padding(start = 25.dp)) {
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
            if (subtitle != null) {
                Text(
                    text = subtitle,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.Gray
                )
            }
        }
    }
}