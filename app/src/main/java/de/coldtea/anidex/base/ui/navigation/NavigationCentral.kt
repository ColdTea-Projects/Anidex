package de.coldtea.anidex.base.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import de.coldtea.anidex.base.data.extensions.orInvalidId
import de.coldtea.anidex.base.ui.navigation.model.GROUP_CONTENT
import de.coldtea.anidex.base.ui.navigation.model.GROUP_MYLIST
import de.coldtea.anidex.base.ui.navigation.model.SCREEN_CONTENT
import de.coldtea.anidex.base.ui.navigation.model.SCREEN_CONTENT_DETAIL
import de.coldtea.anidex.base.ui.navigation.model.SCREEN_MYLIST
import de.coldtea.anidex.base.ui.navigation.model.screenGroups
import de.coldtea.anidex.content.ui.ContentViewModel
import de.coldtea.anidex.contentdetail.ui.ContentDetailScreen
import de.coldtea.anidex.contentdetail.ui.ContentDetailViewModel
import de.coldtea.anidex.ui.content.ContentScreen

@Composable
fun NavigationCentral() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                screenGroups.forEach { group ->
                    BottomNavigationItem(
                        icon = { Icon(painter = painterResource(id = group.iconResourceId), contentDescription = null) },
                        label = { Text(text = stringResource(id = group.textResourceId)) },
                        selected = currentDestination?.hierarchy?.any { it.route == group.route } == true,
                        onClick = {
                            navController.navigate(group.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true
                            }
                        })

                }
            }
        }
    ) { innerPadding ->
        // Apply the padding globally to the whole BottomNavScreensController
        Box(modifier = Modifier.padding(innerPadding)) {
            NavHost(navController = navController, startDestination = GROUP_CONTENT) {
                navigation(startDestination = SCREEN_CONTENT, route = GROUP_CONTENT) {
                    composable(SCREEN_CONTENT) {
                        val contentViewModel = hiltViewModel<ContentViewModel>()

                        ContentScreen(viewModel = contentViewModel) { id ->
                            navController.navigate("$SCREEN_CONTENT_DETAIL/$id")
                        }
                    }
                    composable("$SCREEN_CONTENT_DETAIL/{anime_id}"){ navBackStackEntry ->
                        val animeId: String = navBackStackEntry.arguments?.getString("anime_id").orEmpty()
                        val contentDetailViewModel = hiltViewModel<ContentDetailViewModel>()
                        contentDetailViewModel.fetchAnimeDetail(animeId.toInt().orInvalidId())
                        
                        ContentDetailScreen(viewModel = contentDetailViewModel)
                    }
                }
                navigation(startDestination = SCREEN_MYLIST, route = GROUP_MYLIST) {
                    composable(SCREEN_MYLIST) {

                    }
                }
            }
        }
    }
}