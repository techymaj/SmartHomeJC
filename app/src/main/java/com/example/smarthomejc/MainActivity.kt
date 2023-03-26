package com.example.smarthomejc


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.smarthomejc.ui.theme.SmartHomeJCTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmartHomeJCTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(
                            items = listOf(
                                BottomNavItem("Favorites", "favorites", Icons.Filled.Favorite),
                                BottomNavItem("Things", "things", Icons.Filled.Search),
                                BottomNavItem("Routines", "routines", Icons.Filled.Close),
                                BottomNavItem("Ideas", "ideas", Icons.Filled.Info),
                                BottomNavItem("Settings", "settings", Icons.Filled.Settings)
                            ),
                            navController = navController,
                            onItemClick = {
                                // Handle item click
                                navController.navigate(it.route)
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
                            backgroundColor = Color.Blue,
                            elevation = 5.dp,
                            contentColor = Color.White,
                            actions = {
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        imageVector = Icons.Filled.Edit,
                                        contentDescription = "Edit"
                                    )
                                }
                            }
                        )
                    },
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = { /*TODO*/ },
                            backgroundColor = Color.Blue,
                            contentColor = Color.White,
                            content = {
                                Icon(
                                    imageVector = Icons.Filled.Add,
                                    contentDescription = "Add"
                                )
                            }
                        )
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
                    Column(horizontalAlignment = CenterHorizontally) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.name
                        )
                    }
                },
                label = { Text(item.name) },
                selected = selected,
                selectedContentColor = Color.Blue,
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
    NavHost(navController = navController, startDestination = "favorites") {
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
    }
}

@Composable
fun HomeScreen() {
    Column {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Favorite",
                    modifier = Modifier.size(100.dp),
                    tint = Color.Gray
                )
                Text(
                    text = "No Favorites!",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )
                Text(text = "Add your favorite routines for easy access here.")
                Text(text = "Tap the '+' button below to add your favorite routines.")
            }
        }

    }
}

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

@Composable
fun RoutinesScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Routines")
    }
}

@Composable
fun IdeasScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Ideas")
    }
}

@Composable
fun SettingsScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Settings")
    }
}