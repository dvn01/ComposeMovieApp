package com.dairymaster.composemovieapp.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dairymaster.composemovieapp.MovieRow
import com.dairymaster.composemovieapp.navigation.MovieScreens

@Composable
fun HomeScreen(navController: NavController){
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        TopAppBar(backgroundColor = Color.Magenta,
            elevation = 5.dp,
        ) {
            Text(text = "Movies")
        }
    }) {
        MainContent(navController = navController)
    }
}


@Composable
fun MainContent(navController: NavController,
                movieList: List<String> = listOf("300",
    "Harry Potter",
    "Lord Of the Rings",
    "The Batman",
    "Jaws",
    "Happy Feet",
    "Frozen",
    "The Joker")){
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
