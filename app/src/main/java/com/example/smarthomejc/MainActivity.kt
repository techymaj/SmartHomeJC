package com.example.smarthomejc


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
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
                                BottomNavItem("Favorites", "favorites", Icons.Rounded.Star),
                                BottomNavItem("Things", "things", Icons.Filled.Search),
                                BottomNavItem("Routines", "routines", painter = painterResource(id = R.drawable.ic_update)),
                                BottomNavItem("Ideas", "ideas", painter = if (navController.currentBackStackEntryAsState().value?.destination?.id == 4) painterResource(id = R.drawable.ic_bulb_filled) else painterResource(id = R.drawable.ic_bulb)),
                                BottomNavItem("Settings", "settings", Icons.Filled.Settings),
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
                            backgroundColor = Color.Yellow,
                            elevation = 5.dp,
                            contentColor = Color.White,
                            actions = {
                                IconButton(onClick = { /*TODO*/ }) {
                                        Icon(
                                            imageVector = Icons.Filled.Edit,
                                            contentDescription = "Edit"
                                        )
                                    }
//                                if (navController.currentBackStackEntry?.destination?.route == "favorites") {
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
//                                }
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
                label = { Text(item.name) },
                selected = selected,
                selectedContentColor = Color.Yellow,
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
                    painter = painterResource(id = R.drawable.round_star_border),
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

@Composable
fun IdeasScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 10.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "More Recommendations",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )
            Text(
                "Even more recommendations!",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                textAlign = TextAlign.Start,
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start),
            ) {
                Image(
                    painterResource(id = R.drawable.hallelujah),
                    contentDescription = "Image",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .rotate(180F)
                        .blur(
                            radiusX = 10.dp,
                            radiusY = 10.dp,
                            edgeTreatment = BlurredEdgeTreatment(RoundedCornerShape(8.dp))
                        ),
//                    colorFilter = ColorFilter.lighting(Color.Yellow, Color.Magenta),
                alpha = 0.85f
                )
                Column(
                    modifier = Modifier.padding(all = 10.dp)
                ) {
                    Text(
                        text = "Thanksgiving Dinner Ready",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal,
                    )
                    Text(
                        text = "Send me a notification",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Light,
                    )
                }
            }
        }
    }
}

@Composable
fun SettingsScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            CustomListTitle(title = "User Settings")
            CustomListItem(
                title = "Majaliwa" ,
                subtitle = "wilfriedmajaliwa@gmail.com",
                itemIcon = Icons.Filled.AccountCircle
            )
            CustomListTitle(title = "Home Settings")
            CustomListItem(
                title = "Accounts & Hubs" ,
                itemIcon = Icons.Filled.Person
            )
            Divider()
            CustomListItem(
                title = "Clients" ,
                itemIcon = Icons.Rounded.Phone
            )
            Divider()
            CustomListItem(
                title = "Locations" ,
                itemIcon = Icons.Filled.LocationOn
            )
            CustomListTitle(title = "Voice")
            CustomListItem(
                title = "Voice Assistant" ,
                itemIcon = Icons.Filled.Phone
            )
            CustomListTitle(title = "App Permissions")
            CustomListItem(
                title = "Notifications & Permissions" ,
                itemIcon = Icons.Filled.Settings,
                color = Color.Black
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
fun CustomListItem(title: String, subtitle: String? = null, itemIcon: ImageVector, color: Color = Color.Yellow) {
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