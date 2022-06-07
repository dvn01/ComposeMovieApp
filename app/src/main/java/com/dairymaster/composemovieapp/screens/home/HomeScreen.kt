package com.dairymaster.composemovieapp.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dairymaster.composemovieapp.models.Movie
import com.dairymaster.composemovieapp.models.getMovies
import com.dairymaster.composemovieapp.navigation.MovieScreens
import com.dairymaster.composemovieapp.widgets.MovieRow

@Composable
fun HomeScreen(navController: NavController){
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        TopAppBar(backgroundColor = Color.Transparent,
            elevation = 1.dp,
        ) {
            Row(horizontalArrangement = Arrangement.Start) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Arrow Back Icon",
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    })
            }
            Spacer(modifier = Modifier.width(100.dp))
            Text(text = "Movies List")
        }
    }) {
        MainContent(navController = navController)
    }
}


@Composable
fun MainContent(navController: NavController,
                movieList: List<Movie> = getMovies()){
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(items = movieList){
                MovieRow(it){ movie ->
                    navController.navigate(route = MovieScreens.DetailsScreen.name + "/$movie")
                }
            }
        }
    }
}


