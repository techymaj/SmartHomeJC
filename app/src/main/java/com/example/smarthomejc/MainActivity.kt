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
import androidx.compose.runtime.MutableState
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.smarthomejc.ui.pieces.RoutineClass
import com.example.smarthomejc.ui.theme.SmartHomeJCTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

lateinit var thisRoute: MutableState<String>
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
                thisRoute = remember { mutableStateOf("favorites") }
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
                                thisRoute.value = it.route
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
                                if (thisRoute.value == "things") {
                                    IconButton(onClick = { /*TODO*/ }) {
                                        Icon(
                                            imageVector = Icons.Filled.Search,
                                            contentDescription = "Search"
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(5.dp))
                                    IconButton(onClick = { /*TODO*/ }) {
                                        Icon(
                                            imageVector = Icons.Filled.Menu,
                                            contentDescription = "Menu"
                                        )
                                    }
                                } else {
                                    IconButton(onClick = { /*TODO*/ }) {
                                        Icon(
                                            imageVector = Icons.Filled.Edit,
                                            contentDescription = "Edit"
                                        )
                                    }
                                }
                            }
                        )
                    },
                    floatingActionButton = {
                        if(
                            (thisRoute.value != "things")
                            && (thisRoute.value != "settings")
                            && (thisRoute.value != "createRoutine")
                        ){
                            FloatingActionButton(
                                onClick = {
                                    // Navigate to new screen
                                    if (thisRoute.value == "routines"){
                                        navController.navigate("createRoutine")
                                        thisRoute.value = "createRoutine"
                                    }
                                    if (thisRoute.value == "favorites"){
                                        navController.navigate("routines")
                                        thisRoute.value = "routines"
                                    }
                                    if (thisRoute.value == "routine"){
                                        lazyRoutines.add(RoutineClass(currName, currTime,false,currCont))
                                        //saveRoutinesListToFile(filePath)
                                        navController.navigate("routines")
                                        thisRoute.value = "routines"
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
                //navController = navController,
                onTimeSelected = {}
            )
        }
        composable("eventsScreen") {
            // Create Routine screen
            AddingEventScreen()
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