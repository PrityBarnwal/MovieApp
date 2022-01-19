package com.coolapps.movieapplication.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Column
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
import com.coolapps.movieapplication.model.Movie
import com.coolapps.movieapplication.model.getMovies
import com.coolapps.movieapplication.navigation.MovieScreens
import com.coolapps.movieapplication.widgets.MovieRow

@Composable
fun HomeScreen(navController: NavController){
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.Transparent,
            elevation = 0.dp) {
            Text(text = "Movies")
        }
    },) {
       MainContent(navController = navController)
    }
}

@Composable
fun MainContent(
    navController: NavController,
    movieList : List<Movie> = getMovies() ) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(items = movieList) {
                MovieRow(movie = it) { movie ->
                    navController.navigate(route = MovieScreens.DetailsScreen.name+"/$movie")
                    //Log.d("TAG", "MainContent: $movie")
                }
                // Text(text = it)
            }
        }
    }
}
